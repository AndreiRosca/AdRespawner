package md.utm.internship.web.controller;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import md.utm.internship.rest.client.domain.Photo;
import md.utm.internship.rest.client.domain.Sex;
import md.utm.internship.rest.client.domain.User;
import md.utm.internship.web.service.UserMvcService;

@Controller
@SessionAttributes({ "editedUser" })
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
	public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, 
			Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		user = userService.createUser(user);
		model.addAttribute("userId", user.getId());
		return "redirect:/users/{userId}";
	}
	
	@InitBinder(value = "user")
	public void initBinding(WebDataBinder webDataBinder) {
		webDataBinder.setAllowedFields("login", "password", "email");
	}

	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("sexSelectValues", Sex.values());
	}
	
	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
	public String showProfileEditPage(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute("editedUser", userService.getUser(userId));
		return "editUserProfile";
	}
	
	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.POST)
	public String editUser(@PathVariable("userId") Long id, @ModelAttribute("editedUser") @Valid User user, 
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors())
			return "editUserProfile";
		if (!user.getUserPhotoFile().isEmpty()) {
			String imagePath = request.getServletContext().getRealPath("/");
			Photo userPhoto = userService.moveUploadedUserPhoto(user, imagePath);
			user.setPhoto(userPhoto);	
		}
		user = userService.updateUser(user);
		model.addAttribute("userId", user.getId());
		return "redirect:/users/{userId}";
	}
	
	@InitBinder(value = "editedUser")
	public void setUpUserEditBinding(WebDataBinder webDataBinder) {
		String[] allowedFields = { "email", "firstName", "lastName", 
				"birthDate", "userPhotoFile", "sex", "contacts", "password" };
		webDataBinder.setAllowedFields(allowedFields);
	}
	
	@RequestMapping(value = "/users/{id}/messages", params = { "received" })
	public String showReceivedMessages(@PathVariable("id") Long userId, Model model) {
		model.addAttribute("messageSet", userService.getReceivedMessages(userId));
		return "viewMessages";
	}
	
	@RequestMapping(value = "/users/{id}/messages", params = { "sent" })
	public String showSentMessages(@PathVariable("id") Long userId, Model model) {
		model.addAttribute("messageSet", userService.getSentMessages(userId));
		return "viewMessages";
	}
}
