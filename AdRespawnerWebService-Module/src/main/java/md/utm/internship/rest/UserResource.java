package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import md.utm.internship.model.User;
import md.utm.internship.service.UserService;

@Path("/users")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class UserResource {
	
	private UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GET
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") Long userId) {
		return userService.getUser(userId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createUser(User user) {
		return userService.createUser(user);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(@PathParam("id") Long userId, User user) {
		user.setId(userId);
		return userService.updateUser(user);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteUser(@PathParam("id") Long userId) {
		userService.deleteUser(userId);
	}
	
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MessageResource messageResource(@PathParam("id") Long userId) {
		return new MessageResource(userService, userId);
	}
}
