package com.mattjtodd.dropwizard.websockets;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereServlet;

import javax.servlet.ServletRegistration;

/**
 * Created by mattjtodd on 09/02/15.
 */
public class WebsocketApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new WebsocketApplication().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        AtmosphereServlet servlet = new AtmosphereServlet();
        servlet.framework().addInitParameter("com.sun.jersey.config.property.packages",
                                             this.getClass().getPackage().getName());

        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_SUPPORT, "true");

        ServletRegistration.Dynamic servletHolder = environment.servlets().addServlet("Chat", servlet);
        servletHolder.addMapping("/chat/*");
    }
}
