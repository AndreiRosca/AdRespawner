package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import md.utm.internship.web.service.AdDomainMvcService;

@Controller
public class HomePageController {
	
	private AdDomainMvcService adDomainService;
	
	@Autowired
	public HomePageController(AdDomainMvcService adDomainService) {
		this.adDomainService = adDomainService;
	}

	@RequestMapping(value = "/")
	public String hello(Model model) {
		model.addAttribute("adDomainList", adDomainService.getAllAdDomains());
		return "index";
	}
}
