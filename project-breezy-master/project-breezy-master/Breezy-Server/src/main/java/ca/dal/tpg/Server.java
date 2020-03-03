package ca.dal.tpg;


import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.PermittedOptions;

import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;
import io.vertx.reactivex.core.AbstractVerticle;

import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.eventbus.EventBus;
import io.vertx.reactivex.core.http.HttpServer;

import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.handler.BodyHandler;
import io.vertx.reactivex.ext.web.handler.StaticHandler;
import io.vertx.reactivex.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.reactivex.ext.web.handler.sockjs.SockJSSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Server extends AbstractVerticle {

    private static final Logger log = LoggerFactory.getLogger(Server.class);

    private static Server instance;

    private HttpServer server;
    private Router router;
    private EventBus eb;
    private static AgentClient agentClient;

    private Store store = null;
    private JsonObject jdbcConfig = null;
    private JsonObject agentConfig = null;
    private static JsonObject serverConfig = null;

    private int actionCode = 1;
    private List<Long> dotaClientLatencyLog = new ArrayList<Long>();
    private Long lastFeatureVector;
    private boolean overrideAgent = true;
    private String dotaBetaFolderPath;

    private Integer gameWaitingResponse = 0;
    private boolean isGameWaiting = false;

    private SockJSSocket featureSocket;
    private List<JsonArray> featureBuffer = new ArrayList<>();


    public static Server getInstance(){
        if(instance != null){
            return instance;
        }else {
            log.error("Attempted to get server singleton before init.");
            return null;
        }
    }


    public static JsonObject serverConfig(){
        if(serverConfig != null){
            return serverConfig;
        }else{
            log.error("Config not yet loaded!");
            return null;
        }
    }

    //Start hook
    public void start(){

        log.info("Starting with config: \n{}", config().encodePrettily());

        //Get the event bus
        this.eb = vertx.eventBus();

        //Load JDBC config and create database client
        jdbcConfig = config().getJsonObject("jdbc");
        agentConfig = config().getJsonObject("agent");
        serverConfig = config();
        agentClient = new AgentClient(vertx, agentConfig);
        store = new Store(vertx, jdbcConfig);

        overrideAgent = config().getBoolean("overrideAgent");
        dotaBetaFolderPath = config().getString("dotaBetaFolderPath");

        //Setup and create http server
        HttpServerOptions options = new HttpServerOptions()
                .setPort(config().getJsonObject("httpServer").getInteger("port"))
                .setHost(config().getJsonObject("httpServer").getString("host"));

        server = vertx.createHttpServer(options);

        router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        //Set up SockJS Handler
        BridgeOptions opts = new BridgeOptions()
                .addInboundPermitted( new PermittedOptions()
                    .setAddress("sentry.features"))
                .addInboundPermitted( new PermittedOptions()
                    .setAddress("sentry.latency"))
                .addInboundPermitted( new PermittedOptions()
                    .setAddress("sentry.activeRun"))
                .addOutboundPermitted( new PermittedOptions()
                    .setAddress("sentry.features"))
                .addOutboundPermitted( new PermittedOptions()
                    .setAddress("sentry.latency"))
                .addOutboundPermitted( new PermittedOptions()
                    .setAddress("sentry.activeRun"));

        SockJSHandler handler = SockJSHandler.create(vertx).bridge(opts);
        SockJSHandlerOptions sockJsOptions = new SockJSHandlerOptions().setHeartbeatInterval(2000);
        SockJSHandler socketHandler = SockJSHandler.create(vertx, sockJsOptions);
        socketHandler.socketHandler(socket->{

            this.featureSocket = socket;


        });
        router.route("/eventbus/*").handler(handler);

        router.route().handler(this::handleCors);

        router.route().method(HttpMethod.OPTIONS).handler(this::handleOptions);
        router.route("/stream/features/*").handler(socketHandler);
        router.route(HttpMethod.POST,"/dota2/").handler(this::gameClientHandler);
        router.route(HttpMethod.GET, "/action").handler(this::handleActionCode);
        router.route(HttpMethod.GET, "/features/").handler(this::handleFeatures);
        router.route(HttpMethod.GET, "/state/").handler(this::handleServerState);
        router.route(HttpMethod.POST, "/state/").handler(this::handleNewServerState);
        router.route(HttpMethod.GET, "/agent").handler(this::toggleAgentOverride);
        router.route(HttpMethod.POST, "/agent/config").handler(this::updateAgentConfig);
        router.route(HttpMethod.GET, "/agent/config").handler(this::getAgentConfig);
        router.route(HttpMethod.POST, "/agent/config/test").handler(this::testAgentConfig);
        router.route(HttpMethod.POST, "/run/").handler(this::createRun);
        router.route(HttpMethod.POST, "/run/client").handler(this::processGameInfo);
        router.route(HttpMethod.GET, "/run/active").handler(this::getActiveRunInfo);
        router.route(HttpMethod.DELETE, "/run/active").handler(this::cancelActiveRun);
        router.route(HttpMethod.GET, "/run/:runId").handler(this::getRunInfo);
        router.route(HttpMethod.GET, "/run/").handler(this::getAllRuns);

        //Serve UI
        router.route("/*").handler(StaticHandler.create());

        server.requestHandler(router).rxListen().subscribe(
                success->{
                    log.info("Server started successfully at {} on port {}", config().getString("host"), config().getInteger("port"));
                },
                err->{
                    log.error("Error starting server at {} on port {}", config().getString("host"), config().getInteger("port"));
                    log.error(err.getMessage());
                    err.printStackTrace();
                }
        );

        setupFeatureStreaming();

        instance = this;

    }

    private void getActiveRunInfo(RoutingContext rc){
        Run r = Run.getActiveRun();

        if(r != null){
            rc.response().setStatusCode(200).end(r.toJson().encode());
        }else{
            rc.response().setStatusCode(404).end(
                    new JsonObject()
                    .put("error", "there is no active run!")
                    .encode()
            );
        }
    }

    private void getAllRuns(RoutingContext rc){

        JsonArray runs = new JsonArray();
        Run.getRuns().forEach(r->runs.add(r.toJson()));

        rc.response().setStatusCode(200).end(runs.encode());
    }

    private void getRunInfo(RoutingContext rc){
        try{
            UUID runId = UUID.fromString(rc.request().getParam("runId"));
            Run r = Run.getRun(runId);

            if(r != null){
                rc.response().setStatusCode(200).end(
                        r.toJson().encode()
                );
            }else{
                rc.response().setStatusCode(404).end(
                        new JsonObject()
                                .put("error", "Could not find run with specified id! " +
                                        "Please note that runs are stored in memory, " +
                                        "and runs from previous instances of the server " +
                                        "cannot be retrieved!")
                                .encode()
                );
            }
        }catch (IllegalArgumentException err){
            log.error("Error parsing uuid!");
            log.error(err.getMessage());

            rc.response().setStatusCode(500).end(
                    new JsonObject()
                    .put("error", "Malformed runId!")
                    .encode()
            );
        }

    }

    private void cancelActiveRun(RoutingContext rc){

        Run r =  Run.cancelActiveRun();
        if(r != null){
            rc.response().setStatusCode(200).end(
                    r.toJson().encode()
            );
        }else{
            rc.response().setStatusCode(500).end(
                    new JsonObject()
                    .put("error", "No active run! Cannot cancel nothing!")
                    .encode()
            );
        }

    }

    private void processGameInfo(RoutingContext rc){
        JsonObject gameInfo = rc.getBodyAsJson();
        String gameId = gameInfo.getString("gameId");
        //log.info("gameInfo: {}", gameInfo.encodePrettily());

        if(gameInfo.containsKey("state")){
            switch (gameInfo.getString("state")){
                case "start":
                    //This is a start game request
                    Run.associateGameId(gameId);
                    rc.response().setStatusCode(200).end();
                    break;
                case "end":
                    //This is an end game request
                    Run.completeActiveGame(gameId, gameInfo.getString("winner"),
                            Integer.parseInt(gameInfo.getString("direKills")),
                            Integer.parseInt(gameInfo.getString("radiantKills")),
                            Integer.parseInt(gameInfo.getString("deaths")));
                    rc.response().setStatusCode(200).end();
                    break;
                case "waiting":
                    //log.info("Game Client is waiting!");
                    if(!isGameWaiting){
                        isGameWaiting = true;
                    }
                    rc.response().setStatusCode(200).end(gameWaitingResponse.toString());
                    if(gameWaitingResponse == 1){
                        setGameWaitingResponse(0);
                    }
                    break;
            }
        }


    }

    private void createRun(RoutingContext rc){

        if(Run.getActiveRun() != null){ //Prevent double starting a run.
            rc.response().setStatusCode(500).end(
                    new JsonObject()
                        .put("error",
                                "Cannot start run, there already is an active run! " +
                                "Please cancel or wait for the active run to complete before starting a new one!")
                        .encode()
            );
        }else{

            log.info("Attempting to create run!");
            try{
                JsonObject runInfo = rc.getBodyAsJson();

                Run r = new Run();
                r.setRunId(UUID.randomUUID());
                r.setSize(runInfo.getInteger("size"));
                r.setStartTime(Date.from(Instant.now()));
                r.setStatus(RunStatus.PENDING);
                r.setProgress(0);
                r.setAgentName(runInfo.getString("agent"));

                log.info("run: {}", r.toJson().encodePrettily());

                rc.response().setStatusCode(200).end(r.toJson().encode());

                Run.startRun(r);
            }catch(Exception e){
                log.error(e.getMessage());
                e.printStackTrace();
            }

        }
    }



    private void setupFeatureStreaming(){

        vertx.setPeriodic(config().getLong("feature.stream.delay"), t->{

            if(featureSocket != null && featureBuffer.size() > 0){
                featureSocket.rxWrite(new Buffer(featureBuffer.remove(0).toBuffer()))
                        .subscribe();
            }

            //log.info("avgLatency: {}", getServerState().getLong("averageClientLatency"));
            eb.publish("sentry.latency", getServerState());

        });

    }

    /** Handle POSTs sent from the dota 2 client!
     *
     * @param rc Routing context of the request
     */
    private void gameClientHandler(RoutingContext rc){

        Instant iStart = Instant.now();

        JsonObject features = rc.getBodyAsJson();
        String gameId = features.getString("gameId");

        Run.registerFeatureVector(gameId);

        JsonArray featuresArray = features.getJsonArray("features");
        featureBuffer.add(featuresArray);

        if(!overrideAgent){
            agentClient.relay(featuresArray).future().rxSetHandler().subscribe(
                    response->{
                        //Send response back to dota 2 client
                        rc.response().end(String.valueOf(response.getInteger("actionCode")));
                    }
            );
        }else{

            rc.response().rxEnd(String.valueOf(this.actionCode)).subscribe(
                    ()->{
                           Instant iEnd = Instant.now();
                           log.info("Server response time: {}ms", iEnd.toEpochMilli()-iStart.toEpochMilli());
                    }
            );
        }

        //Compute Dota Client latency stats
        if(lastFeatureVector == null){
            lastFeatureVector = Date.from(Instant.now()).getTime();
        }else{
            long current = Date.from(Instant.now()).getTime();
            dotaClientLatencyLog.add( current - lastFeatureVector);
            lastFeatureVector = current;

            //Keep 60 records
            if(dotaClientLatencyLog.size() > 60){
                dotaClientLatencyLog.remove(0);
            }
        }

        /* Run async - save features to database and send them out in real
         * time through websockets to the front end client.*/
        vertx.rxExecuteBlocking(db->{

            log.info(features.encodePrettily());

            log.info("features length: {}", featuresArray.size());

            Features f = Features.fromJsonArray(gameId, featuresArray);

            store.insertFeatures(f);
            log.info("Saved features!");

        }).subscribe();

    }

    private void toggleAgentOverride(RoutingContext rc){
        this.overrideAgent = Boolean.parseBoolean(rc.request().getParam("override"));
        rc.response()
                .setStatusCode(200)
                .end(getServerState().encode());
    }

    public static AgentClient getAgentClient(){
        return agentClient;
    }

    private void getAgentConfig(RoutingContext rc){
        JsonObject response = agentConfig.copy();
        response.put("connected", agentClient.isConnected());

        rc.response()
                .setStatusCode(200)
                .end(response.encode());
    }

    private void handleActionCode(RoutingContext rc){

        //If we were passed a value parameter
        if(rc.queryParams().contains("value"))
        { //Infer this to mean that we want to set the action code
            int newCode = Integer.parseInt(rc.queryParams().get("value"));
            this.actionCode = newCode;
            rc.response()
                    .setStatusCode(200)
                    .end(getServerState().encode());
        }
        else //If no value was passed, return all action codes
        {
            Action[] actions = Action.values();
            JsonArray result = new JsonArray();
            Arrays.stream(actions).forEach(action -> {
                result.add(new JsonObject()
                    .put("name", action.friendlyName())
                    .put("action", action.name())
                    .put("code", action.code())
                );
            });

            rc.response()
                    .setStatusCode(200)
                    .end(result.encode());
        }



    }

    private void testAgentConfig(RoutingContext rc){
        try{
            agentClient.testConfig(rc.getBodyAsJson()).future().rxSetHandler().subscribe(
                    response->{
                        rc.response().setStatusCode(200).end(response.encode());
                    },
                    err->{
                        rc.response().setStatusCode(500).end(new JsonObject().encode());
                    }
            );
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }

    private void updateAgentConfig(RoutingContext rc){
        agentConfig = rc.getBodyAsJson();
        agentClient.setConfig(agentConfig).future().rxSetHandler().subscribe(
                result->{
                    JsonObject response = agentConfig.copy();
                    response.put("connected", result);
                    rc.response()
                            .setStatusCode(200)
                            .end(response.encode());
                },
                err->{
                    rc.response().setStatusCode(500).end(new JsonObject().encode());
                }
        );

    }

    private void handleServerState(RoutingContext rc){
        try{
            rc.response()
                    .setStatusCode(200)
                    .end(getServerState().encode());
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }

    private void handleNewServerState(RoutingContext rc){
        JsonObject data = rc.getBodyAsJson();

        if(data.containsKey("dotaBetaFolderPath")){
            this.dotaBetaFolderPath = data.getString("dotaBetaFolderPath");
        }

        if(data.containsKey("actionCode")){
            this.actionCode = data.getInteger("actionCode");
        }

        if(data.containsKey("overrideAgent")){
            this.overrideAgent = data.getBoolean("overrideAgent");
        }

        rc.response().setStatusCode(200).end(getServerState().encode());
    }

    private void handleCors(RoutingContext rc){
        rc.response()
                .putHeader("Content-Type","application/json")
                .putHeader("Access-Control-Allow-Headers", "content-type")
                .putHeader("Access-Control-Allow-Methods", "*")
                .putHeader("Access-Control-Allow-Origin", "*");
        rc.next();
    }

    private void handleOptions(RoutingContext rc){
        rc.response().setStatusCode(200).end();
    }

    private JsonObject getServerState(){
        JsonArray latencyData = new JsonArray();
        //Calculate average client latency
        Long sum = 0L;
        for(Long dataPoint: dotaClientLatencyLog ){
            sum += dataPoint;
            latencyData.add(dataPoint);
        }

        Long average = -1L;

        //Avoid dividing by 0.
        if(dotaClientLatencyLog.size() != 0){
            average = sum/dotaClientLatencyLog.size();
        }


        JsonObject result = new JsonObject()
                .put("agentConfig", agentConfig)
                .put("overrideAgent", overrideAgent)
                .put("actionCode", this.actionCode)
                .put("averageClientLatency", average)
                .put("clientLatencyData", latencyData)
                .put("dotaBetaFolderPath", dotaBetaFolderPath);


        return result;
    }

    //Return a list of features
    private void handleFeatures(RoutingContext rc){
        Feature[] features = Feature.values();
        JsonArray result = new JsonArray();
        Arrays.stream(features).forEach(
                feature -> {
                    result.add(new JsonObject()
                            .put("name", feature.friendlyName())
                            .put("index", feature.index()));
                }
                );

        rc.response()
                .setStatusCode(200)
                .end(result.encode());

    }

    public Router router(){
        return router;
    }

    public String getDotaBetaFolderPath(){
        return dotaBetaFolderPath;
    }

    public EventBus eb(){
        return eb;
    }

    public void setGameWaitingResponse(Integer gameWaitingResponse) {
        this.gameWaitingResponse = gameWaitingResponse;
    }

    public boolean isGameWaiting(){
        return isGameWaiting;
    }
}
