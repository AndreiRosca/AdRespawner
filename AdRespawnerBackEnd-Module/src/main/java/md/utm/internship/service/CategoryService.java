package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.Category;

public interface CategoryService {
	List<Category> getAllCategories(Long adDomainId);
	Category getCategory(Long id);
	Category createCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Long id);
}
