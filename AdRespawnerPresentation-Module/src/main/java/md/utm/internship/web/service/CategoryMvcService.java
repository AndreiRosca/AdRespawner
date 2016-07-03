package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.Category;

public interface CategoryMvcService {
	List<Category> getAllCategories();
	void setAdDomainId(Long adDomainId);
}
