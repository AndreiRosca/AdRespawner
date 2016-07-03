package md.utm.internship.web.service;

import java.util.List;

import md.utm.internship.rest.client.domain.Ad;


public interface AdMvcService {
	List<Ad> getAllAds();
	void setAdSubResourceId(Long adSubResourceId);
}
