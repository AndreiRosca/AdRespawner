package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.domain.Category;
import md.utm.internship.rest.client.domain.SubCategory;

public interface CategoryMvcService {
	List<Category> getAllCategories(Long adDomainId);
	SubCategory getSubcategoryById(Long adDomainId, Long subCategoryId);
	boolean adDomainHasSubcategory(Long adDomainId, Long subCategoryId);
}
