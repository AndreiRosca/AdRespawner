package md.utm.internship.web.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import md.utm.internship.rest.client.domain.Ad;
import md.utm.internship.web.consumer.FreshAdConsumer;
import md.utm.internship.web.decoder.JsonDecoder;
import md.utm.internship.web.service.CategoryMvcService;

@ServerEndpoint(value = "/newAdNotifierByCategory/{adDomainId}")
public class WebSocketCategoryFreshAdConsumer implements FreshAdConsumer  {

	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<>());
	
	private Logger logger = Logger.getLogger(getClass());
	private static JsonDecoder decoder;
	private static CategoryMvcService categoryService;
	
	public WebSocketCategoryFreshAdConsumer() {
		
	}
	
	public WebSocketCategoryFreshAdConsumer(JsonDecoder decoder, CategoryMvcService categoryService) {
		WebSocketCategoryFreshAdConsumer.decoder = decoder;
		WebSocketCategoryFreshAdConsumer.categoryService = categoryService;
	}
	
	@OnOpen
	public void onOpen(Session session, @PathParam("adDomainId") Long adDomainId) {
		session.getUserProperties().put("chosenAdDomainId", adDomainId);
		peers.add(session);
		logger.info("Opening session: " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session) {
		peers.remove(session);
		logger.info("Closing session: " + session.getId());
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		logger.error("Error: " + session.getId(), throwable);
	}

	@Override
	public void consumeFreshAd(String jsonAd) {
		for (Session s : peers) {
			if (s.isOpen()) {
				Long adDomainId = (Long) s.getUserProperties().get("chosenAdDomainId");
				Ad ad = decoder.decode(jsonAd, Ad.class);
				if (categoryService.adDomainHasSubcategory(adDomainId, ad.getSubCategory().getId())) {
					s.getAsyncRemote().sendText(jsonAd);
				}
			}
		}
	}
}
