package md.utm.internship.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import md.utm.internship.rest.client.domain.Category;
import md.utm.internship.web.service.CategoryMvcService;

@RestController
public class AdInsertionRestController {

	@Autowired
	private CategoryMvcService categoryService;
	
	@GetMapping(value = "/getCategories/{id}")
	public @ResponseBody List<Category> getAllCategories(@PathVariable("id") Long adDomainId) {
		return categoryService.getAllCategories(adDomainId);
	}
}
