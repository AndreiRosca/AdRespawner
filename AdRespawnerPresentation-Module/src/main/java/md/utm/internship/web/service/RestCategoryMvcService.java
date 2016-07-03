package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.Category;
import md.utm.internship.rest.client.CategoryResourceClient;

public class RestCategoryMvcService implements CategoryMvcService {

	private CategoryResourceClient categoryResource;
	
	public RestCategoryMvcService(CategoryResourceClient categoryResource) {
		this.categoryResource = categoryResource;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return categoryResource.getAllCategories();
	}

	@Override
	public void setAdDomainId(Long adDomainId) {
		categoryResource.setAdDomainId(adDomainId);
	}
}
