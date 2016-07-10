package md.utm.internship.gateway;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import md.utm.internship.model.AdDomain;

@Repository
public class JpaAdDomainGateway implements AdDomainGateway {

	private EntityManager em;

	@Autowired
	public JpaAdDomainGateway(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<AdDomain> getAllAdDomains() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<AdDomain> adDomains = em.createQuery("select a from AdDomain a", AdDomain.class)
				 					 .getResultList();
		tx.commit();
		return adDomains;
	}

	@Override
	public AdDomain getAdDomain(Long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		AdDomain adDomain = em.createQuery("select a from AdDomain a where a.id = :id", AdDomain.class)
							  .setParameter("id", id)
							  .getSingleResult();
		tx.commit();
		return adDomain;
	}

	@Override
	public void createAdDomain(AdDomain adDomain) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(adDomain);
		tx.commit();
	}

	@Override
	public void updateAdDomain(AdDomain adDomain) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(adDomain);
		tx.commit();
	}

	@Override
	public void deleteAdDomain(AdDomain adDomain) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(adDomain);
		tx.commit();
	}
}
