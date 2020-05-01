package ca.dal.tpg;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Promise;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgentClient {

    private static final Logger log = LoggerFactory.getLogger(AgentClient.class);

    private JsonObject config = null;
    private Vertx vertx = null;
    private WebClient client = null;
    private JsonObject lastStatus = null;
    private boolean connected = false;

    public AgentClient(Vertx vertx, JsonObject config){
        this.vertx = vertx;
        client = WebClient.create(vertx);
        /*Be sure to set config after client is created, as
          set config tests the connection with the agent*/
        setConfig(config).future().rxSetHandler().subscribe(
                done->{
                    log.info("Configuration tested successfully!");
                },
                err->{
                    log.error("Configuration test failed! is the connect.route on the agent implemented properly?");
                }
        );
    }

    /**Allows to change the config at runtime.
     * @param config new agent configuration json.
     */
    public Promise<Boolean> setConfig(JsonObject config){
        Promise<Boolean> result = Promise.promise();
        this.config = config;

        connect().future().rxSetHandler().subscribe(
                status->{
                    this.lastStatus = status;
                    this.connected = true;
                    result.complete(connected);
                },
                err->{
                    this.connected = false;
                    result.fail(err);
                }
        );
        return result;
    }

    public Promise<JsonObject> testConfig(JsonObject config){
        Promise<JsonObject> result = Promise.promise();
        connect(config.getInteger("port"),
                config.getString("host"),
                config.getString("connect.route")).future().rxSetHandler().subscribe(
                        status->{
                            JsonObject info = new JsonObject()
                                    .put("status", status)
                                    .put("connected", true);
                            result.complete(info);
                        },
                err->{
                            JsonObject info = new JsonObject()
                                    .put("connected", false);
                            result.complete(info);
                }
        );
        return result;
    }

    public boolean isConnected(){
        return connected;
    }

    /**Wrapper for relay method that uses
     * port, host and path parameters defined
     * in the config object.
     *
     * @param features The feature json array to pass to the agent.
     * @return A promise with the json response from the agent.
     */
    public Promise<JsonObject> relay(JsonArray features){
        return relay(
                config.getInteger("port"),
                config.getString("host"),
                config.getString("relay.route"),
                features
                );
    }

    /**Relays a feature json array to an agent and passes the agent's response
     * back in a Promise<JsonObject>.
     *
     * @param port Agent port.
     * @param host Agent host.
     * @param path Agent relay route.
     * @param features The feature json array to pass to the agent.
     * @return A promise with the json response from the agent.
     */
    public Promise<JsonObject> relay(Integer port, String host, String path, JsonArray features){
        Promise<JsonObject> promise = Promise.promise();
        client.post(port, host, path)
                .putHeader("Content-Type", "application/json")
                .rxSendJson(features)
                .subscribe(
                        response->{
                            if(response.statusCode() == 200){
                                promise.complete(response.bodyAsJsonObject());
                            }else{
                                try{
                                    log.info("Agent relay response status code: {}", response.statusCode());
                                    JsonObject data = response.bodyAsJsonObject();
                                    promise.complete(data);
                                }catch (Exception e){
                                    log.error(e.getMessage());
                                    e.printStackTrace();
                                    promise.fail("Probably cannot parse agent response!");
                                }

                            }
                        },
                        err->{
                            log.error(err.getMessage());
                            err.printStackTrace();
                            promise.fail(err);
                        }
                );
        return promise;
    }

    /**Wrapper for connect method that uses
     * port, host and path parameters defined
     * in the config object.
     * @return A promise object containing the json object representing
     * the agent's status.
     */
    public Promise<JsonObject> connect(){
        return connect(
                config.getInteger("port"),
                config.getString("host"),
                config.getString("connect.route")
                );
    }

    /**Connects to the agent and reports
     * its status.
     * @return A promise object containing the json object representing
     * the agent's status.
     */
    public Promise<JsonObject> connect(Integer port, String host, String path){
        Promise<JsonObject> promise = Promise.promise();
        client.get(
                port,
                host,
                path
        ).rxSend().subscribe(
                response->{
                    if(response.statusCode() == 200){
                        promise.complete(response.bodyAsJsonObject());
                    }else{
                        try{
                            log.info("Agent connect response status code: {}", response.statusCode());
                            JsonObject data = response.bodyAsJsonObject();
                            promise.complete(data);
                        }catch (Exception e){
                            log.error(e.getMessage());
                            e.printStackTrace();
                            promise.fail("Probably cannot parse agent response!");
                        }
                    }

                },
                err->{
                    log.error(err.getMessage());
                    err.printStackTrace();
                    promise.fail(err);
                }
        );
        return promise;
    }

    public Promise<JsonObject> sendGameEndNotification(JsonObject data){
        return sendGameEndNotification(
            config.getInteger("port"),
            config.getString("host"),
            config.getString("run.update.route"),
            data
        );
    }

    private Promise<JsonObject> sendGameEndNotification(Integer port, String host, String path, JsonObject notification){
        Promise<JsonObject> promise = Promise.promise();
        client.post(port,host,path)
                .putHeader("Content-Type", "application/json")
                .rxSendJsonObject(notification)
                .subscribe(
                    response->{
                        if(response.statusCode() == 200){
                            promise.complete(response.bodyAsJsonObject());
                        }else{
                            try{
                                log.info("Agent gameEnd notification response status code: {}", response.statusCode());
                                JsonObject data = response.bodyAsJsonObject();
                                promise.complete(data);
                            }catch (Exception e){
                                log.error(e.getMessage());
                                e.printStackTrace();
                                promise.fail("Probably cannot parse agent response!");
                            }
                        }

                    },
                    err->{
                        promise.fail(err);
                    }
                );

        return promise;
    }


}
