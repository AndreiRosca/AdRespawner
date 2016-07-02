package md.utm.internship.gateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import md.utm.internship.model.Category;

@Repository
public class InMemoryCategoryGateway implements CategoryGateway {
	
	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();
	private AtomicLong idGenerator = new AtomicLong(0);
	
	@Autowired
	public InMemoryCategoryGateway(AdDomainGateway adDomainGateway) {
		createCategory(new Category("Computers", adDomainGateway.getAdDomain(1L)));
		createCategory(new Category("Laptops", adDomainGateway.getAdDomain(1L)));
		createCategory(new Category("Components", adDomainGateway.getAdDomain(1L)));
		createCategory(new Category("Video", adDomainGateway.getAdDomain(2L)));
	}

	@Override
	public List<Category> getAllCategories(Long adDomainId) {
		return categories.values()
						 .stream()
						 .filter(c -> c.getAdDomain().getId().equals(adDomainId))
						 .collect(Collectors.toList());
	}

	@Override
	public Category getCategory(Long id) {
		return categories.get(id);
	}

	@Override
	public Category createCategory(Category category) {
		category.setId(idGenerator.incrementAndGet());
		categories.putIfAbsent(category.getId(), category);
		return category;
	}

	@Override
	public Category updateCategory(Category category) {
		category.setAdDomain(categories.get(category.getId()).getAdDomain());
		categories.put(category.getId(), category);
		return category;
	}

	@Override
	public void deleteCategory(Long id) {
		categories.remove(id);
	}
}
