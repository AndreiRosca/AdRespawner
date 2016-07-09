package md.utm.internship.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import md.utm.internship.gateway.UserGateway;
import md.utm.internship.model.Message;
import md.utm.internship.model.User;

@Service
public class BasicUserService implements UserService {
	
	private static AtomicLong idGenerator = new AtomicLong(0);
	private UserGateway userGateway;

	@Autowired
	public BasicUserService(UserGateway userGateway) {
		this.userGateway = userGateway;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userGateway.getAllUsers();
	}

	@Override
	public User getUser(Long userId) {
		return userGateway.getUser(userId);
	}

	@Override
	public User createUser(User user) {
		return userGateway.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userGateway.updateUser(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userGateway.deleteUser(userId);
	}

	@Override
	public Set<Message> getReceivedMessages(Long userId) {
		return userGateway.getUser(userId).getReceivedMessages();
	}

	@Override
	public Set<Message> getSentMessages(Long userId) {
		return userGateway.getUser(userId).getSentMessages();
	}

	@Override
	public Message sendMessage(Message message) {
		User sender = userGateway.getUser(message.getSender().getId());
		User receiver = userGateway.getUser(message.getReceiver().getId());
		message = new Message(sender, receiver, message.getMessage());
		message.setId(idGenerator.incrementAndGet());
		sender.getSentMessages().add(message);
		receiver.getReceivedMessages().add(message);
		userGateway.updateUser(sender);
		userGateway.updateUser(receiver);
		return message;
	}
}
