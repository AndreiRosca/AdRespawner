package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.UserResourceClient;
import md.utm.internship.rest.client.domain.User;

public class RestUserMvcService implements UserMvcService {

	private UserResourceClient userResourceClient;
	
	public RestUserMvcService(UserResourceClient userResourceClient) {
		this.userResourceClient = userResourceClient;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userResourceClient.getAllUsers();
	}

	@Override
	public User getUser(Long userId) {
		return userResourceClient.getUser(userId);
	}

	@Override
	public User createUser(User user) {
		return userResourceClient.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userResourceClient.updateUser(user.getId(), user);
	}

	@Override
	public void deleteUser(Long userId) {
		userResourceClient.deleteUser(userId);
	}
}
