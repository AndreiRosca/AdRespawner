package md.utm.internship.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import md.utm.internship.rest.client.domain.Category;

public class CategoryResourceClient {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	private String categoryResourceUrl;
	
	public CategoryResourceClient(String categoryResourceUrl) {
		this.categoryResourceUrl = categoryResourceUrl;
	}
	
	public List<Category> getAllCategories(Long adDomainId) {
		setAdDomainId(adDomainId);
		return target.path("/categories")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<Category>>() {});
	}
	
	public Category getCategory(Long id) {
		return target.path("/categories/")
					 .path(id.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<Category>() {});
	}
	
	public Category createCategory(Category category) {
		return target.path("/categories")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(category), Category.class);
	}
	
	public Category updateCategory(Long id, Category category) {
		return target.path("/categories/")
					 .path(id.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .put(Entity.json(category), Category.class);
	}
	
	public void deleteCategory(Long id) {
		target.path("/categories/")
			  .path(id.toString())
			  .request()
			  .delete();
	}
	
	public void dispose() {
		client.close();
	}

	public void setAdDomainId(Long adDomainId) {
		target = client.target(categoryResourceUrl + "/" + adDomainId);
	}
}
