package md.utm.internship.gateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import md.utm.internship.model.Category;
import md.utm.internship.model.SubCategory;

@Repository
public class InMemoryCategoryGateway implements CategoryGateway {
	
	private ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();
	private AtomicLong idGenerator = new AtomicLong(0);
	
	@Autowired
	public InMemoryCategoryGateway(AdDomainGateway adDomainGateway) {
		Category first = new Category("Computers", adDomainGateway.getAdDomain(1L));
		SubCategory s1 = new SubCategory("Laptops", first);
		s1.setId(40L);
		first.getSubCategories().add(s1);
		createCategory(first);
		Category second = new Category("Software", adDomainGateway.getAdDomain(1L));
		SubCategory s2 = new SubCategory("Software", second);
		s2.setId(41L);
		second.getSubCategories().add(s2);
		createCategory(second);
		Category third = new Category("Components", adDomainGateway.getAdDomain(1L));
		SubCategory s3 = new SubCategory("HDD", third);
		s3.setId(42L);
		third.getSubCategories().add(s3);
		SubCategory s32 = new SubCategory("Motherboards", third);
		s32.setId(43L);
		third.getSubCategories().add(s32);
		createCategory(third);
		Category fourth = new Category("Video", adDomainGateway.getAdDomain(2L));
		SubCategory s4 = new SubCategory("Projectors and Monitors", fourth);
		s4.setId(44L);
		fourth.getSubCategories().add(s4);
		createCategory(fourth);
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
