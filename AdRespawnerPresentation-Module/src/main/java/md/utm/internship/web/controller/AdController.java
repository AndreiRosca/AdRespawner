package md.utm.internship.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ads/{id}")
public class AdController {

	@GetMapping
	public String showAds(Model model, @PathVariable("id") Long id) {
		model.addAttribute("adList", "This is the list of ads");
		return "ad";
	}
}
