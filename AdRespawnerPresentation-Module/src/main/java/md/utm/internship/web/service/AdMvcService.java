package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.domain.Ad;


public interface AdMvcService {
	List<Ad> getAllAds();
	Ad getAd(Long adId);
	void setAdSubResourceId(Long adSubResourceId);
}
