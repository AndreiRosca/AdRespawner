package md.utm.internship.web.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

import md.utm.internship.web.consumer.FreshAdConsumer;

public class FreshAdListener implements MessageListener {

	private TopicConnection connection;
	private TopicSession session;
	private Topic freshAdsTopic;
	private TopicSubscriber subscriber;
	private FreshAdConsumer consumer;
	
	public FreshAdListener(FreshAdConsumer consumer) {
		this.consumer = consumer;
		TopicConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			connection = cf.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			freshAdsTopic = session.createTopic("EM_FRESH_ADS.T");
			subscriber = session.createSubscriber(freshAdsTopic);
			subscriber.setMessageListener(this);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			consumer.consumeFreshAd(textMessage.getText());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
