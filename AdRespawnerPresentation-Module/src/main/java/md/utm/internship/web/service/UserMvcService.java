package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.domain.User;

public interface UserMvcService {
	List<User> getAllUsers();
	User getUser(Long userId);
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(Long userId);
}
