package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.CategoryResourceClient;
import md.utm.internship.rest.client.domain.Category;
import md.utm.internship.rest.client.domain.SubCategory;

public class RestCategoryMvcService implements CategoryMvcService {

	private CategoryResourceClient categoryResource;
	
	public RestCategoryMvcService(CategoryResourceClient categoryResource) {
		this.categoryResource = categoryResource;
	}
	
	@Override
	public List<Category> getAllCategories(Long adDomainId) {
		categoryResource.setAdDomainId(adDomainId);
		return categoryResource.getAllCategories();
	}

	@Override
	public SubCategory getSubcategoryById(Long adDomainId, Long subCategoryId) {
		return getAllCategories(adDomainId).stream()
										   .flatMap(c -> c.getSubCategories().stream())
										   .filter(s -> s.getId().equals(subCategoryId))
										   .findAny()
										   .orElseThrow(() -> new RuntimeException("Didn't find the subcategory."));
	}
}
