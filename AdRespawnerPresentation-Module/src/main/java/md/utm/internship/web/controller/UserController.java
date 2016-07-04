package md.utm.internship.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import md.utm.internship.rest.client.domain.User;
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
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		user = userService.createUser(user);
		model.addAttribute("userId", user.getId());
		return "redirect:/users/{userId}";
	}
	
	@InitBinder
	public void initBinding(WebDataBinder webDataBinder) {
		webDataBinder.setAllowedFields("login", "password", "email");
	}
}
