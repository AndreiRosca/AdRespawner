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
	
	private AdMvcService adService;
	
	@Autowired
	public AdController(AdMvcService adService) {
		this.adService = adService;
	}

	@GetMapping
	public String showAdList(Model model, @PathVariable("id") Long id) {
		adService.setAdSubResourceId(id);
		model.addAttribute("adList", adService.getAllAds());
		return "adList";
	}
	
	@RequestMapping("/ad/{id}")
	public String viewAd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ad", adService.getAd(id));
		return "viewAd";
	}
	
	public void setAdMvcService(AdMvcService adService) {
		this.adService = adService;
	}
}
