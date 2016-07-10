package md.utm.internship.gateway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import md.utm.internship.model.AdDomain;
import md.utm.internship.model.Category;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdRespawnerBackEnd-Module");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		AdDomain adDomain = null;
		adDomain = em.find(AdDomain.class, 1L);
		Category c = new Category("Transport", adDomain);
		em.persist(c);
		tx.commit();
		em.close();
		emf.close();
	}
}
