package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import md.utm.internship.rest.client.domain.Message;
import md.utm.internship.web.service.UserMvcService;

@RestController
public class MessageRestController {

	@Autowired
	private UserMvcService userService;
	
	@PostMapping("/sendMessage")
	public @ResponseBody Message sendMessage(@RequestBody Message message) {
		return userService.sendMessage(message);
	}
}
