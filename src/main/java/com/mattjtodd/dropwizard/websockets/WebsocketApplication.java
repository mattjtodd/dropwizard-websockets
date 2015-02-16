/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mattjtodd.dropwizard.websockets;

import javax.servlet.ServletRegistration;

import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereServlet;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

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
        String name = this.getClass().getPackage().getName();
		servlet.framework().addInitParameter("com.sun.jersey.config.property.packages", name);

        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_SUPPORT, "true");

        ServletRegistration.Dynamic servletHolder = environment.servlets().addServlet("Chat", servlet);
        servletHolder.addMapping("/chat/*");
    }
}
