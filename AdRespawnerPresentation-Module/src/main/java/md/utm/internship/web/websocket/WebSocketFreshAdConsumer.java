package md.utm.internship.web.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import md.utm.internship.web.consumer.FreshAdConsumer;

@ServerEndpoint(value = "/newAdNotifier")
public class WebSocketFreshAdConsumer implements FreshAdConsumer {
	
	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<>());
	
	private Logger logger = Logger.getLogger(getClass());

	@OnOpen
	public void onOpen(Session session) {
		peers.add(session);
		logger.info("Opening the session: " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session) {
		peers.remove(session);
		logger.info("Closing the session: " + session.getId());
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		logger.error("Error: " + session.getId(), throwable);
	}
	
	@Override
	public void consumeFreshAd(String jsonAd) {
		for (Session s : peers) {
			if (s.isOpen())
				s.getAsyncRemote().sendText(jsonAd);
		}
	}
}
