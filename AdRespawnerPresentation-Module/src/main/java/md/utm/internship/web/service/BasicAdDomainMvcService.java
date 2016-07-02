package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.AdDomain;
import md.utm.internship.rest.client.AdDomainResourceClient;

public class BasicAdDomainMvcService implements AdDomainMvcService {
	
	private AdDomainResourceClient adDomainClient;
	
	public BasicAdDomainMvcService(AdDomainResourceClient adDomainClient) {
		this.adDomainClient = adDomainClient;
	}

	@Override
	public List<AdDomain> getAllAdDomains() {
		return adDomainClient.getAllAdDomains();
	}
}
