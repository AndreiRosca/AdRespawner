package md.utm.internship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import md.utm.internship.gateway.AdDomainGateway;
import md.utm.internship.model.AdDomain;

@Service
public class BasicAdGatewayService implements AdDomainService {
	
	private AdDomainGateway adDomainGateway;
	
	@Autowired
	public BasicAdGatewayService(AdDomainGateway adDomainGateway) {
		this.adDomainGateway = adDomainGateway;
	}

	@Override
	public List<AdDomain> getAllAdDomains() {
		return adDomainGateway.getAllAdDomains();
	}

	@Override
	public AdDomain getAdDomain(Long id) {
		return adDomainGateway.getAdDomain(id);
	}

	@Override
	public void createAdDomain(AdDomain adDomain) {
		adDomainGateway.createAdDomain(adDomain);
	}

	@Override
	public void updateAdDomain(AdDomain adDomain) {
		adDomainGateway.updateAdDomain(adDomain);
	}

	@Override
	public void deleteAdDomain(AdDomain adDomain) {
		adDomainGateway.deleteAdDomain(adDomain);
	}
}
