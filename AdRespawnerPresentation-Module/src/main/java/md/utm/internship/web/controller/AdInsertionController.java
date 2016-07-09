package md.utm.internship.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import md.utm.internship.rest.client.domain.Ad;
import md.utm.internship.rest.client.domain.Currency;
import md.utm.internship.rest.client.domain.Photo;
import md.utm.internship.web.service.AdDomainMvcService;
import md.utm.internship.web.service.AdMvcService;

@Controller
public class AdInsertionController {
	
	@Autowired
	private AdDomainMvcService adDomainService;
	
	@Autowired
	private AdMvcService adService;

	@GetMapping("/addAd")
	public String showAdAdditionPage(Model model) {
		model.addAttribute("adDomainList", adDomainService.getAllAdDomains());
		model.addAttribute("newAd", new Ad());
		model.addAttribute("availableCurrencies", Currency.values());
		return "addAd";
	}
	
	@PostMapping("/addAd")
	public String addNewAd(@ModelAttribute("newAd") @Valid Ad newAd, BindingResult bindingResult, 
			Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors())
			return "/addAd";
		String basePath = request.getServletContext().getRealPath("/");
		List<Photo> photos = adService.moveUploadedAdPhotoFiles(basePath, newAd.getAdPhotos());
		newAd.setPhotos(photos);
		adService.setAdSubResourceId(newAd.getSubCategory().getId());
		newAd = adService.createAd(newAd);
		model.addAttribute("adId", newAd.getId());
		model.addAttribute("subCategoryId", newAd.getSubCategory().getId());
		return "redirect:ads/{subCategoryId}/ad/{adId}";
	}
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		
	}
}
