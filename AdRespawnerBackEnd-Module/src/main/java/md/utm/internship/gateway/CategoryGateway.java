package md.utm.internship.gateway;

import java.util.List;

import md.utm.internship.model.Category;

public interface CategoryGateway {
	List<Category> getAllCategories(Long adDomainId);
	Category getCategory(Long id);
	Category createCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Long id);
}
