package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.AdDomainResourceClient;
import md.utm.internship.rest.client.domain.AdDomain;

public class RestAdDomainMvcService implements AdDomainMvcService {
	
	private AdDomainResourceClient adDomainClient;
	
	public RestAdDomainMvcService(AdDomainResourceClient adDomainClient) {
		this.adDomainClient = adDomainClient;
	}

	@Override
	public List<AdDomain> getAllAdDomains() {
		return adDomainClient.getAllAdDomains();
	}
}
