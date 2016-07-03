package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import md.utm.internship.web.service.AdMvcService;

@Controller
@RequestMapping("/ads/{id}")
public class AdController {
	
	@Autowired
	private AdMvcService adService;

	@GetMapping
	public String showAds(Model model, @PathVariable("id") Long id) {
		adService.setAdSubResourceId(id);
		model.addAttribute("adList", adService.getAllAds());
		return "ad";
	}
}
