package md.utm.internship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import md.utm.internship.gateway.AdGateway;
import md.utm.internship.model.Ad;

@Service
public class BasicAdService implements AdService {

	@Autowired
	private AdGateway adGateway;
	
	@Override
	public List<Ad> getAllAds(Long categoryId) {
		return adGateway.getAllAds(categoryId);
	}

	@Override
	public Ad getAd(Long adId) {
		return adGateway.getAd(adId);
	}

	@Override
	public Ad createAd(Ad ad) {
		return adGateway.createAd(ad);
	}

	@Override
	public Ad updateAd(Ad ad) {
		return adGateway.updateAd(ad);
	}

	@Override
	public void deleteAd(Long adId) {
		adGateway.deleteAd(adId);
	}
}
