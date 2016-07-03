package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUser(Long userId);
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(Long userId);
}
