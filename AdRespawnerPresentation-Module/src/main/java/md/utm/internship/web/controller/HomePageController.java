package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import md.utm.internship.web.service.AdDomainMvcService;

@Controller
public class HomePageController {
	
	@Autowired
	private AdDomainMvcService adDomainService;

	@RequestMapping(value = "/")
	public String mainPage(Model model) {
		model.addAttribute("adDomainList", adDomainService.getAllAdDomains());
		return "index";
	}
	
	public void setAdDomainMvcService(AdDomainMvcService adDomainService) {
		this.adDomainService = adDomainService;
	}
}
