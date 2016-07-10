package md.utm.internship.web.listener;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

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
import javax.naming.Context;
import javax.naming.InitialContext;

import md.utm.internship.web.consumer.FreshAdConsumer;

public class FreshAdListener implements MessageListener {

	private TopicConnection connection;
	private TopicSession session;
	private Topic freshAdsTopic;
	private TopicSubscriber subscriber;
	private Set<FreshAdConsumer> consumers = new CopyOnWriteArraySet<>();

	public FreshAdListener() {
		try {
			Context ctx = new InitialContext();
			TopicConnectionFactory cf = (TopicConnectionFactory) ctx.lookup("java:/comp/env/jms/ConnectionFactory");
			connection = cf.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			freshAdsTopic = (Topic) ctx.lookup("java:/comp/env/jms/freshAdsTopic");
			subscriber = session.createSubscriber(freshAdsTopic);
			subscriber.setMessageListener(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public FreshAdListener(Set<FreshAdConsumer> consumers) {
		this();
		this.consumers = consumers;
	}

	public void addConsumer(FreshAdConsumer consumer) {
		consumers.add(consumer);
	}

	public void dispose() {
		try {
			connection.close();
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			for (FreshAdConsumer consumer : consumers)
				consumer.consumeFreshAd(textMessage.getText());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
