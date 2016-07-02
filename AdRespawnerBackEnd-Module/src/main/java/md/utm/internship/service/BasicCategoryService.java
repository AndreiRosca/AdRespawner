package md.utm.internship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Category> getAllCategories(Long adDomainId) {
		return categoryGateway.getAllCategories(adDomainId);
	}

	@Override
	public Category getCategory(Long id) {
		return categoryGateway.getCategory(id);
	}

	@Override
	public Category createCategory(Category category) {
		return categoryGateway.createCategory(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryGateway.updateCategory(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryGateway.deleteCategory(id);
	}
}
