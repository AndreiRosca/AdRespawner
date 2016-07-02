package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

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
		return categoryService.getAllCategories(adDomain.getId());
	}

	@GET
	@Path("{id}")
	public Category getCategory(@PathParam("id") Long id) {
		return categoryService.getCategory(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Category createCategory(Category category) {
		category.setAdDomain(adDomain);
		return categoryService.createCategory(category);
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Category updateCategory(@PathParam("id") Long id, Category category) {
		category.setId(id);
		return categoryService.updateCategory(category);
	}

	@DELETE
	@Path("{id}")
	public void deleteCategory(@PathParam("id") Long id) {
		categoryService.deleteCategory(id);
	}
}
