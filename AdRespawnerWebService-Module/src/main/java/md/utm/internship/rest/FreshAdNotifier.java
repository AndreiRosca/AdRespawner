package md.utm.internship.rest;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import md.utm.internship.model.Ad;
import md.utm.internship.rest.listener.FreshAdListener;

@Component
public class FreshAdNotifier implements FreshAdListener {
	
	private TopicConnection connection;
	private TopicSession session;
	private Topic freshAdTopic;
	private TopicPublisher publisher;
	
	public FreshAdNotifier() {
		TopicConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			connection = cf.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			freshAdTopic = session.createTopic("EM_FRESH_ADS.T");
			publisher = session.createPublisher(freshAdTopic);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void dispose() {
		try {
			connection.close();
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void adCreated(Ad newAd) {
		try {
			TextMessage message = session.createTextMessage();
			message.setText(convertToJSON(newAd));
			publisher.publish(message);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String convertToJSON(Ad ad) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(ad);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
