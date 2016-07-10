package md.utm.internship.rest.client;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import md.utm.internship.rest.client.domain.Message;
import md.utm.internship.rest.client.domain.User;

public class UserResourceClient {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	public UserResourceClient(String resourceUrl, ClientRequestFilter authFilter) {
		client = client.register(authFilter);
		target = client.target(resourceUrl);
	}
	
	public List<User> getAllUsers() {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<User>>() {});
	}
	
	public User getUser(Long userId) {
		return target.path(userId.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<User>() {});
	}
	
	public User createUser(User user) {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(user), User.class);
	}
	
	public User updateUser(Long userId, User user) {
		return target.path(userId.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .put(Entity.json(user), User.class);
	}
	
	public void deleteUser(Long userId) {
		target.path(userId.toString())
			  .request()
			  .delete();
	}
	
	public Set<Message> getReceivedMessages(Long userId) {
		return target.path(userId.toString())
					 .path("receivedMessages")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<LinkedHashSet<Message>>() {});
	}
	
	public Set<Message> getSentMessages(Long userId) {
		return target.path(userId.toString())
					 .path("sentMessages")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<LinkedHashSet<Message>>() {});
	}
	
	public Message sendMessage(Message message) {
		return target.path(message.getSender().getId().toString())
					 .path("/messages")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(message), Message.class);
	}
	
	public void dispose() {
		client.close();	
	}
}
