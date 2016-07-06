package md.utm.internship.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import md.utm.internship.rest.client.domain.Ad;
import md.utm.internship.web.service.AdDomainMvcService;

@Controller
public class AdInsertionController {
	
	@Autowired
	private AdDomainMvcService adDomainService;

	@GetMapping("/addAd")
	public String showAdAdditionPage(Model model) {
		model.addAttribute("adDomainList", adDomainService.getAllAdDomains());
		model.addAttribute("newAd", new Ad());
		return "addAd";
	}
	
	@PostMapping("/addAd")
	public String addNewAd(@ModelAttribute("newAd") @Valid Ad newAd, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "/addAd";
		}
		System.out.println(newAd);
		return "redirect:/ad/{adId}";
	}
}
