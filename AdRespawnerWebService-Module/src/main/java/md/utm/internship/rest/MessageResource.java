package md.utm.internship.rest;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import md.utm.internship.model.Message;
import md.utm.internship.service.UserService;

public class MessageResource {

	private UserService userService;
	private Long userId;

	public MessageResource(UserService userService, Long userId) {
		this.userService = userService;
		this.userId = userId;
	}
	
	@GET
	@Path("/receivedMessages")
	public Set<Message> getReceivedMessages() {
		return userService.getReceivedMessages(userId);
	}
	
	@GET
	@Path("/sentMessages")
	public Set<Message> getSentMessages() {
		return userService.getSentMessages(userId);
	}
	
	@Path("/messages")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Message sendMessage(Message message) {
		return userService.sendMessage(message);
	}
}
