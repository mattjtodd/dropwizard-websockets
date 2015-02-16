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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.Heartbeat;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;

/**
 * A simple Atmosphere service which is able to send a chat message to all connected clients.
 * 
 * @author Matt Todd
 */
@ManagedService(atmosphereConfig = ApplicationConfig.MAX_INACTIVE + "=120000")
public class ChatService
{
	private final Logger logger = Logger.getLogger(ChatService.class.getName());

	@Heartbeat
	public void onHeartbeat(final AtmosphereResourceEvent event)
	{
		log("Heartbeat send by {0}", event.getResource());
	}

	@Ready
	public void onReady(AtmosphereResource atmosphereResource)
	{
		log("Browser {0} connected", atmosphereResource);

	}

	@Disconnect
	public void onDisconnect(AtmosphereResourceEvent event)
	{
		if (event.isCancelled())
		{
			log("Browser {0} unexpectedly disconnected", event.getResource().uuid());
		}
		else if (event.isClosedByClient())
		{
			log("Browser {0} closed the connection", event.getResource().uuid());
		}
	}

	@Message(decoders = JacksonCodec.class, encoders = JacksonCodec.class)
	public ChatMessage onMessage(AtmosphereResource resource, ChatMessage chatMessage)
	{
		log("{0} just sent {1}", resource, chatMessage);

		return chatMessage;

	}

	private void log(String message, Object... params)
	{
		logger.log(Level.INFO, message, params);
	}
}
