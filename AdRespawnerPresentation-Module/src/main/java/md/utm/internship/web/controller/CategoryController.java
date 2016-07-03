package md.utm.internship.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import md.utm.internship.web.service.CategoryMvcService;

@Controller
@RequestMapping(value = "/category/{id}")
public class CategoryController {
	
	private CategoryMvcService categoryService;

	@Autowired
	public CategoryController(CategoryMvcService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public String getCategories(@PathVariable("id") Long adDomainId, Model model) {
		categoryService.setAdDomainId(adDomainId);
		model.addAttribute("categoryList", categoryService.getAllCategories());
		return "category";
	}
	
	public void setCategoryMvcService(CategoryMvcService categoryService) {
		this.categoryService = categoryService;
	}
}
