package md.utm.internship.web.websocket;

import md.utm.internship.web.consumer.FreshAdConsumer;

public class WebSocketFreshAdConsumer implements FreshAdConsumer {

	@Override
	public void consumeFreshAd(String jsonAd) {
		System.out.println(jsonAd);
	}
}
