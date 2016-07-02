package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.Category;

public interface CategoryService {
	List<Category> getAllCategories();
	Category getCategory(Long id);
	void createCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Long id);
}
