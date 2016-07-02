package md.utm.internship.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@RequestMapping(value = "/")
	public String hello(Model model) {
		model.addAttribute("greeting", "This is amazing");
		return "index";
	}
}
