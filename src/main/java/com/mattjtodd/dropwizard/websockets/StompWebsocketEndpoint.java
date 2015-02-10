package com.mattjtodd.dropwizard.websockets;

import org.atmosphere.stomp.annotation.StompEndpoint;
import org.atmosphere.stomp.annotation.StompService;

/**
 * Created by mattjtodd on 09/02/15.
 */
@StompEndpoint
public class StompWebsocketEndpoint {

    @StompService(destination = "/foo")
    public void foo() {
        
    }
}
