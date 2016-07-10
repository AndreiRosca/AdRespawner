package md.utm.internship.gateway;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.Category;

@Repository
public class JpaCategoryGateway implements CategoryGateway {
	
	private EntityManager em;

	public JpaCategoryGateway(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Category> getAllCategories(Long adDomainId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		final String jpql = "select c from Category c where c.adDomain.id = :id";
		List<Category> categories = em.createQuery(jpql, Category.class)
									  .setParameter("id", adDomainId)
									  .getResultList();
		tx.commit();
		return categories;
	}

	@Override
	public Category getCategory(Long categoriId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Category category = em.createQuery("select c from Category c where c.id = :id", Category.class)
							  .setParameter("id", categoriId)
							  .getSingleResult();
		tx.commit();
		return category;
	}

	@Override
	public Category createCategory(Category category) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(category);
		tx.commit();
		return category;
	}

	@Override
	public Category updateCategory(Category category) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(category);
		tx.commit();
		return category;
	}

	@Override
	public void deleteCategory(Long categoryId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createQuery("delete c from Category c where c.id = :id")
		  .setParameter("id", categoryId)
		  .executeUpdate();
		tx.commit();
	}
}
