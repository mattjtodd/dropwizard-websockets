package com.mattjtodd.dropwizard.websockets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atmosphere.cache.UUIDBroadcasterCache;
import org.atmosphere.client.TrackMessageSizeInterceptor;
import org.atmosphere.config.service.AtmosphereHandlerService;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor;
import org.atmosphere.interceptor.BroadcastOnPostAtmosphereInterceptor;
import org.atmosphere.interceptor.HeartbeatInterceptor;

import javax.ws.rs.Path;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by mattjtodd on 09/02/15.
 */
@ManagedService(path = "/chat", atmosphereConfig = ApplicationConfig.MAX_INACTIVE + "=120000")
public class WebsocketService{

    private final ObjectMapper mapper = new ObjectMapper();

    @Message
    public String onMessage(String s) throws IOException {

        Logger.getAnonymousLogger().info("************************* " + s);

        return s;
    }
}
