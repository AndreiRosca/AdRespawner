package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.AdDomain;

public interface AdDomainService {
	List<AdDomain> getAllAdDomains();
	AdDomain getAdDomain(Long id);
	void createAdDomain(AdDomain adDomain);
	void updateAdDomain(AdDomain adDomain);
	void deleteAdDomain(AdDomain adDomain);
}
