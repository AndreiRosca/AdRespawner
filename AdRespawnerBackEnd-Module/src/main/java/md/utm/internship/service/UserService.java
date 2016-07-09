package md.utm.internship.service;

import java.util.List;
import java.util.Set;

import md.utm.internship.model.Message;
import md.utm.internship.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUser(Long userId);
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(Long userId);
	Set<Message> getReceivedMessages(Long userId);
	Set<Message> getSentMessages(Long userId);
	Message sendMessage(Message message);
	Message getReceivedMessage(Long messageId);
	Message getSentMessage(Long messageId);
	Message getMessageById(Long messageId);
}
