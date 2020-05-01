package ca.dal.tpg;

import ca.dal.tpg.exceptions.FailedToStartDota2;
import io.vertx.core.Context;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import io.vertx.reactivex.core.Promise;
import io.vertx.reactivex.ext.web.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.time.Instant;
import java.util.*;


public class Run {

    private static final Logger log = LoggerFactory.getLogger(Run.class);
    private static Run activeRun;
    private static List<Run> completedRuns = new ArrayList<>();
    private static List<Run> canceledRuns = new ArrayList<>();

    private UUID runId;
    private List<String> history = new ArrayList<>(); /** A list of all game id's associated with this run */
    private List<String> crashHistory = new ArrayList<>();
    private String activeGameId;
    private int size; /** The number of times the run should be repeated **/
    private Date startTime;
    private Date endTime;
    private Long duration; //Duration of this run in milliseconds
    private RunStatus status;
    private int progress; /** The number of completed games so far. progress/size = % complete*/
    private Exception error;
    private String agentName;
    private Promise<String> gameStarted; //A promise, that completes when we have a gameId from the dota client.
    private Long lastFeatureVector;
    private Promise<Void> gameDone; //A promise, that completes when the game client reports the game is over
    private Promise<Void> agentReady; //A promise, that completes when the agent hits a webhook to signal it's ready for the next game
    private Route webhook; //The current webhook route to be hit, triggering the next game in a run.
    private String winner;
    private Integer direKills;
    private Integer radiantKills;
    private Integer deaths;

    private Process activeProcess;

    /** Retrieves the active run if one exists.
     *
     * @return the active run if it exists, otherwise null.
     */
    public static Run getActiveRun(){
        if(activeRun != null){
            return activeRun;
        }else{
            log.info("No active run to retrieve!");
            return null;
        }
    }

    /** Retrieves all runs on this server, that is, the active run if one exists as well
     *  as any completed or canceled runs.
     *
     *  NOTE: Runs are kept in memory, it is not possible to retrieve runs from a previous
     *  instance of the server.
     *
     * @return a list of all runs on this server
     */
    public static List<Run> getRuns(){
        List<Run> result = new ArrayList<>();

        if(activeRun != null){
            result.add(activeRun);
        }

        completedRuns.forEach(r->result.add(r));
        canceledRuns.forEach(r->result.add(r));

        return result;
    }

    /** Retrieves a run by id, searches through the active run, the completed runs and canceled runs.
     *  NOTE: Runs are kept in memory, it is not possible to retrieve runs from a previous
     *  instance of the server.
     * @param id UUID of the run to be retrieved.
     * @return the run with the specified id or null if it could not be found.
     */
    public static Run getRun(UUID id){
        if(activeRun.getRunId().equals(id)){
            return activeRun;
        }

        for(Run run: completedRuns){
            if(run.getRunId().equals(id)){
                return run;
            }
        }

        for(Run run: canceledRuns){
            if(run.getRunId().equals(id)){
                return run;
            }
        }

        return null;
    }

    public static void handleDotaProcessCrash(int exitValue){
        if(activeRun != null){
            log.info("DotaProcessCrash Handler invoked!");
            activeRun.crash(exitValue);

            Server.getInstance().eb().publish("sentry.activeRun", activeRun.toJson());
            activeRun.gameDone.tryComplete();
        }
    }

    /** Cancels the active run if one exists.
     *
     * @return the canceled run or null if there was no active run.
     */
    public static Run cancelActiveRun(){
        if(activeRun != null){
            try{
                activeRun.cancel();
                canceledRuns.add(activeRun);
                Run result = activeRun;
                activeRun = null;

                //Notify agent of canceled run...
                Server.getAgentClient().sendGameEndNotification(result.toJson()).future().rxSetHandler().subscribe(
                        notificationAcknowledged->{
                            log.info("Agent ({}) notified of canceled run.");
                        },
                        err->{
                            log.error("Error notifying agent of canceled run! Is the run.update.route implemented properly on the agent?");
                        }
                );

                return result;
            }catch (InterruptedException ie){
                log.error("Error canceling active run!");
                log.error(ie.getMessage());
                ie.printStackTrace();
            }
        }

        return null;
    }

    public static void completeActiveGame(String gameId,
                                          String winner,
                                          int direKills,
                                          int radiantKills,
                                          int deaths){
        if(activeRun != null){
            if(activeRun.getStatus() == RunStatus.INPROGRESS && activeRun.getActiveGameId().equals(gameId)){
                activeRun.setWinner(winner);
                activeRun.setDireKills(direKills);
                activeRun.setRadiantKills(radiantKills);
                activeRun.setDeaths(deaths);

                activeRun.gameDone.tryComplete();
            }else{
                log.error("Attempted to complete a game that isn't INPROGRESS or that doesn't match the active game id... this shouldn't happen");
            }
        }else{
            log.error("No active game to complete!");
        }
    }

    public static void registerFeatureVector(String gameId){
        if(!activeRun.getActiveGameId().equals(gameId)){
            log.error("Received feature vector is not associated with the active run! This shouldn't happen!");
        }else{
            activeRun.update();
        }
    }

    public static void associateGameId(String gameId){
        /* Find the first run whose status is STARTING to determine
           which run this game belongs to.
         */

        log.info("Attempting to associate game!");
        log.info("Active run: {}", activeRun.toJson().encodePrettily());

        if(activeRun.getStatus() == RunStatus.STARTING){
            activeRun.gameStarted().complete(gameId);
            log.info("gameId {} associated with the active run {}", gameId, activeRun.getRunId().toString());
        }
    }

    public static void startRun(Run r){

        registerRun(r);

        //Clear the previous stats and any errors
        r.setWinner(null);
        r.setDireKills(null);
        r.setRadiantKills(null);
        r.setDeaths(null);
        r.setError(null);

        log.info("Run*: {}", r.toJson().encodePrettily());
        log.info("Run activeProcess: {}", r.activeProcess);
        log.info("Server.getInstance().isGameWaiting(): {}", Server.getInstance().isGameWaiting());

        if(r.activeProcess != null && r.activeProcess.isAlive()){
            Server.getInstance().setGameWaitingResponse(1);
        }else{
            try{
                r.activeProcess = r.startDota2();
            }catch (FailedToStartDota2 e){
                log.error(e.getMessage());
                log.error("Affected Run: {}", r.toJson());
            }
        }

        log.info("Starting run {}", r.getRunId());
        r.setStatus(RunStatus.STARTING);
        //Send run status update to sentry
        Server.getInstance().eb().publish("sentry.activeRun", r.toJson());

        Promise<String> gameStarted = Promise.promise();
        r.setGameStarted(gameStarted);

        gameStarted.future().rxSetHandler().subscribe(gameId->{
            r.setActiveGameId(gameId);
            r.setStatus(RunStatus.INPROGRESS);
            //Send run status update to sentry
            Server.getInstance().eb().publish("sentry.activeRun", r.toJson());
        });

        Promise<Void> gameDone = Promise.promise();
        r.setGameDone(gameDone);

        gameDone.future().rxSetHandler().subscribe(d->{

            //If game done is being invoked after a crash, it will not have a game id, and the dota2 process will have already crashed.
            //TODO some major refactoring is going to be required here.
            log.info("{} reported done!", r.getActiveGameId());
            if(r.activeGameId != null){
                r.history.add(r.activeGameId);
                r.setActiveGameId(null); //Clear the gameId
            }

            r.progress++;


            if(r.getSize() > r.getProgress()){
                log.info("More games to do!");
                log.info("{}", r.toJson().encodePrettily());

                if(Server.serverConfig().getBoolean("bypass.agent.ready.between.games")){
                    startRun(r);
                }else{

                    //Generate this run's webhook, and start the run when the agentReady promise completes.
                    r.generateWebhook();
                    r.agentReady.future().rxSetHandler().subscribe(
                            ready-> startRun(r)
                    );
                    r.setStatus(RunStatus.WAITING);

                    log.info("{}", r.toJson().encodePrettily());

                    //Send run status update to sentry
                    Server.getInstance().eb().publish("sentry.activeRun", r.toJson());

                    //Everything is set up, notify the agent
                    Server.getAgentClient().sendGameEndNotification(r.toJson()).future().rxSetHandler().subscribe(
                            notificationAcknowledged->{
                                log.info("Agent ({}) notified of game end, awaiting webhook hit...", r.agentName);
                                log.info("Response from agent server:{}",notificationAcknowledged.encodePrettily());
                            },
                            err->{
                                log.error("Error notifying agent! Is the run.update.route implemented properly on the agent?");
                                log.error(err.getMessage());
                            }
                    );


                }
            }else {
                log.info("all games done!");

                completeRun(r);
                //Send run status update to sentry
                Server.getInstance().eb().publish("sentry.activeRun", r.toJson());

                //Kill the game process
                r.activeProcess.destroyForcibly().waitFor();

                log.info("{}", r.toJson().encodePrettily());
                if(!Server.serverConfig().getBoolean("bypass.agent.ready.between.games")){
                    Server.getAgentClient().sendGameEndNotification(r.toJson()).future().rxSetHandler().subscribe(
                            notificationAcknowledged->{
                                log.info("Agent ({}) notified of game end, awaiting webhook hit...", r.agentName);
                                log.info("Response from agent server:{}",notificationAcknowledged.encodePrettily());
                            },
                            err->{
                                log.error("Error notifying agent of end of run! Is the run.update.route implemented properly?");
                                log.error(err.getMessage());
                            }
                    );
                }
            }

        });

    }

    /** Adds the run to the active run list, but only
     *  if it hasn't already been added.
     *
     * @param r the run to register.
     */
    private static void registerRun(Run r){

        if(activeRun == null){
            activeRun = r;
        }else{
            if(activeRun.getRunId().equals(r.getRunId())){
                return;
            }else{
                log.info("Overwriting active run!");
                activeRun = r;
            }
        }

    }

    private static void completeRun(Run r){
        r.setEndTime(Date.from(Instant.now()));
        r.duration = r.getEndTime().getTime()-r.getStartTime().getTime();
        r.setStatus(RunStatus.DONE);
        completedRuns.add(activeRun);
        activeRun = null;
    }

    private void setGameDone(Promise<Void> p){
        this.gameDone = p;
    }

    public Promise<String> gameStarted(){
        return gameStarted;
    }

    private void setGameStarted(Promise<String> f ){
        this.gameStarted = f;
    }

    private void update(){
        this.lastFeatureVector = Date.from(Instant.now()).getTime();
    }

    private Process startDota2() throws FailedToStartDota2 {
        try{
            Runtime rt = Runtime.getRuntime();

            /** It seems I can run without the -override_vpk, -addon ,-sw and -steam flags when testing the local addon....
             *  this may merit further investigation someday...
             */
            String cmd = Server.getInstance().getDotaBetaFolderPath() + "game\\bin\\win64\\dota2.exe -override_vpk -addon "+
                    Server.serverConfig().getString("workshop_addon_id") +
                    " -tools -condebug -sw -steam +dota_launch_custom_game " +
                    Server.serverConfig().getString("workshop_addon_id") +
                    " dota";

            log.info("cmd: {}", cmd);

            ProcessBuilder pb = new ProcessBuilder(Server.getInstance().getDotaBetaFolderPath() + "game\\bin\\win64\\dota2.exe",
                    "-override_vpk",
                    "-addon",
                    Server.serverConfig().getString("workshop_addon_id"),
                    "-tools",
                    "-condebug",
                    "-sw",
                    "-steam",
                    "+dota_launch_custom_game",
                    Server.serverConfig().getString("workshop_addon_id"),
                    "dota");

            //For crash debugging
            pb.redirectOutput(new File("dota_output"));
            pb.redirectError(new File("dota_error"));
            pb.redirectInput(new File("dota_input"));
            Process ps = pb.start();

            Context vertxContext = Server.getInstance().getVertx().getOrCreateContext();

            log.info("Thread: {}", Thread.currentThread().getName());

            Thread processMonitor = new Thread(()->{
                log.info("Thread: {}", Thread.currentThread().getName());
                try {
                    log.info("Waiting for dota2.exe to terminate!");
                    ps.waitFor();
                    log.info("exit value: {}", ps.exitValue());

                    final int processExitValue = ps.exitValue();

                    vertxContext.runOnContext(v->{
                        log.info("Thread: {}", Thread.currentThread().getName());

                        //If this isn't a user closing the dota client or the game existing normally
                        if(processExitValue != 0 && processExitValue != 1){
                            handleDotaProcessCrash(processExitValue);
                        }

                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            processMonitor.start();


            return ps;

        }catch (Exception e){
            log.error("Failed to start dota 2!");
            log.error(e.getMessage());
            e.printStackTrace();

            throw new FailedToStartDota2(this, e.getMessage(), e);
        }
    }

    public JsonObject toJson(){
        JsonObject result = new JsonObject()
                .put("id", runId.toString());

        if(activeGameId != null){
            result.put("activeGameId", activeGameId);
        }

        result
            .put("size", size)
            .put("startTime", startTime.toString());

        if(endTime != null){
            result.put("endTime", endTime.toString());
        }
        result
            .put("duration", getDuration())
            .put("status", status.name())
            .put("progress",  progress);

        JsonArray historyArray = new JsonArray();

        history.forEach(s->{
            historyArray.add(s);
        });

        result.put("gameIds", historyArray);

        if(error != null){
            result.put("error", error.getMessage());
        }

        if(webhook != null){
            result.put("webhook", webhook.getPath());
        }

        if(winner != null){
            result.put("winner", winner);
        }

        if(direKills != null){
            result.put("direKills", direKills);
        }

        if(radiantKills != null){
            result.put("radiantKills", radiantKills);
        }

        if(deaths != null){
            result.put("deaths", deaths);
        }

        if(crashHistory.size() > 0){

            JsonArray crashArray = new JsonArray();

            crashHistory.forEach(s->{
                crashArray.add(s);
            });

            result.put("crashedGames", crashArray);
        }

        return result;
    }

    /** Returns the duration of the run. If the run has not yet completed
     *  (ie: there is no endTime and therefor no value set as the final
     *  duration. Then the active run duration is calculated by subtracting
     *  the current time from the start time.
     *
     * @return The duration of this run in milliseconds.
     */
    public long getDuration(){
        if(duration != null){
            return duration;
        }else {
            return Date.from(Instant.now()).getTime() - startTime.getTime();
        }
    }

    public void generateWebhook(){

        agentReady = Promise.promise();

        webhook =  Server.getInstance().router().route(HttpMethod.GET,
                Server.serverConfig().getString("run.webhook.prefix") +
                getRunId().toString() +
                Server.serverConfig().getString("run.webhook.suffix")
                );

        webhook.handler(rc->{
            log.info("Webhook invoked by agent ({})!", agentName);
            agentReady.complete();
            status = RunStatus.STARTING;
            webhook.remove(); //Remove the route after we're done to prevent strange behavior/double invokes.
            webhook = null;
            rc.response().setStatusCode(200).end(toJson().encode());
        });

    }

    public void crash(int exitValue){
        log.info("Game crash detected, handling...");
        status = RunStatus.ERROR;
        if( exitValue == -1073741819){
            setError(new Exception("Suspected accessViolation has occured crashing game ("+getActiveGameId()+"), dota2.exe crashed with exit value " + exitValue));
        }else{
            setError(new Exception("Unexpected error caused the game ("+getActiveGameId()+") to crash with exit value " + exitValue));
        }
        crashHistory.add(getActiveGameId());
        setActiveGameId(null);
        log.info("Adding an extra game to make up for the lost game");
        size += 1;
        activeProcess = null;
    }

    public void cancel() throws InterruptedException {
        activeProcess.destroyForcibly().waitFor();
        setActiveGameId(null); //Clear the game id
        endTime = Date.from(Instant.now());
        duration = getEndTime().getTime() - getStartTime().getTime();
        status = RunStatus.CANCELED;
    }

    public Integer getDireKills() {
        return direKills;
    }

    public void setDireKills(Integer direKills) {
        this.direKills = direKills;
    }

    public Integer getRadiantKills() {
        return radiantKills;
    }

    public void setRadiantKills(Integer radiantKills) {
        this.radiantKills = radiantKills;
    }

    public Long getLastFeatureVector() {
        return lastFeatureVector;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public String getActiveGameId() {
        return activeGameId;
    }

    public void setActiveGameId(String activeGameId) {
        this.activeGameId = activeGameId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public UUID getRunId() {
        return runId;
    }

    public void setRunId(UUID runId) {
        this.runId = runId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public RunStatus getStatus() {
        return status;
    }

    public void setStatus(RunStatus status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }
}
