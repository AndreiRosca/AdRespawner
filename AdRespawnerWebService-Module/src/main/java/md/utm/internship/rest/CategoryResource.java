package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.GET;

import md.utm.internship.model.AdDomain;
import md.utm.internship.model.Category;
import md.utm.internship.service.CategoryService;

public class CategoryResource {

	private AdDomain adDomain;
	private CategoryService categoryService;

	public CategoryResource(AdDomain adDomain, CategoryService categoryService) {
		this.adDomain = adDomain;
		this.categoryService = categoryService;
	}
	
	@GET
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
}
