package md.utm.internship.gateway;

import java.util.List;

import md.utm.internship.model.User;

public interface UserGateway {
	List<User> getAllUsers();
	User getUser(Long userId);
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(Long userId);
}
