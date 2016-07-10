package md.utm.internship.gateway;

import java.util.List;

import javax.persistence.EntityManager;

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
		return em.createQuery("select a from AdDomain a", AdDomain.class)
				 .getResultList();
	}

	@Override
	public AdDomain getAdDomain(Long id) {
		return em.createQuery("select a from AdDomain a where a.id = :id", AdDomain.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}

	@Override
	public void createAdDomain(AdDomain adDomain) {
		em.persist(adDomain);
	}

	@Override
	public void updateAdDomain(AdDomain adDomain) {
		em.merge(adDomain);
	}

	@Override
	public void deleteAdDomain(AdDomain adDomain) {
		em.remove(adDomain);
	}
}
