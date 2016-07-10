package md.utm.internship.gateway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import md.utm.internship.model.AdDomain;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdRespawnerBackEnd-Module");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		AdDomain adDomain = new AdDomain("Transport");
		System.out.println(em.createQuery("select a from AdDomain a").getResultList());
		tx.commit();
		em.close();
		emf.close();
	}
}
