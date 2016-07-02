package md.utm.internship.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import md.utm.internship.gateway.CategoryGateway;
import md.utm.internship.model.Category;

@Service
public class BasicCategoryService implements CategoryService {

	private CategoryGateway categoryGateway;

	@Autowired
	public BasicCategoryService(CategoryGateway categoryGateway) {
		this.categoryGateway = categoryGateway;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryGateway.getAllCategories();
	}

	@Override
	public Category getCategory(Long id) {
		return categoryGateway.getCategory(id);
	}

	@Override
	public void createCategory(Category category) {
		categoryGateway.createCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryGateway.updateCategory(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryGateway.deleteCategory(id);
	}
}
