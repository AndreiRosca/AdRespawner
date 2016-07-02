package md.utm.internship.gateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.Category;

@Repository
public class InMemoryCategoryGateway implements CategoryGateway {
	
	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();
	private AtomicLong idGenerator = new AtomicLong(0);
	
	public InMemoryCategoryGateway() {
		
	}

	@Override
	public List<Category> getAllCategories() {
		return categories.values()
						 .stream()
						 .collect(Collectors.toList());
	}

	@Override
	public Category getCategory(Long id) {
		return categories.get(id);
	}

	@Override
	public void createCategory(Category category) {
		category.setId(idGenerator.incrementAndGet());
		categories.putIfAbsent(category.getId(), category);
	}

	@Override
	public void updateCategory(Category category) {
		categories.put(category.getId(), category);
	}

	@Override
	public void deleteCategory(Long id) {
		categories.remove(id);
	}
}
