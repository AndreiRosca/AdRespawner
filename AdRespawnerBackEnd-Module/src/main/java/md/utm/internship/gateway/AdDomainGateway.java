package md.utm.internship.gateway;

import java.util.List;

import md.utm.internship.model.AdDomain;

public interface AdDomainGateway {
	List<AdDomain> getAllAdDomains();
	AdDomain getAdDomain(Long id);
	void createAdDomain(AdDomain adDomain);
	void updateAdDomain(AdDomain adDomain);
	void deleteAdDomain(AdDomain adDomain);
}
