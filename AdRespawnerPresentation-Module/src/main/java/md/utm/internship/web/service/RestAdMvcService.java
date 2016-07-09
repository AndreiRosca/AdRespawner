package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.AdResourceClient;
import md.utm.internship.rest.client.domain.Ad;

public class RestAdMvcService implements AdMvcService {
	
	private AdResourceClient adResourceClient;

	public RestAdMvcService(AdResourceClient adResourceClient) {
		this.adResourceClient = adResourceClient;
	}
	
	@Override
	public List<Ad> getAllAds() {
		return adResourceClient.getAllAds();
	}

	@Override
	public void setAdSubResourceId(Long adSubResourceId) {
		adResourceClient.setAdSubcategoryId(adSubResourceId);
	}

	@Override
	public Ad getAd(Long adId) {
		return adResourceClient.getAd(adId);
	}

	@Override
	public Ad createAd(Ad ad) {
		return adResourceClient.createAd(ad);
	}
}
