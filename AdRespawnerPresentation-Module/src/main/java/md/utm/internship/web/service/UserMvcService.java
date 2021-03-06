package md.utm.internship.web.service;

import java.util.List;
import java.util.Set;

import md.utm.internship.rest.client.domain.Message;
import md.utm.internship.rest.client.domain.Photo;
import md.utm.internship.rest.client.domain.User;

public interface UserMvcService {
	List<User> getAllUsers();
	User getUser(Long userId);
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(Long userId);
	Photo moveUploadedUserPhoto(User user, String targetFolder);
	Set<Message> getReceivedMessages(Long userId);
	Set<Message> getSentMessages(Long userId);
	Message sendMessage(Message message);
}
