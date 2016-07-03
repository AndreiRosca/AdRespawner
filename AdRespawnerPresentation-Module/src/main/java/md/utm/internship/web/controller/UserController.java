package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import md.utm.internship.web.service.UserMvcService;

@Controller
public class UserController {

	@Autowired
	private UserMvcService userService;
	
	@RequestMapping(value = "/users/{id}")
	public String showUserProfile(@PathVariable("id") Long userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		return "userProfile";
	}
}
