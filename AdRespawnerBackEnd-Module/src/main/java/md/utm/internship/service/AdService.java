package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.Ad;

public interface AdService {
	List<Ad> getAllAds(Long categoryId);
	Ad getAd(Long adId);
	Ad createAd(Ad ad);
	Ad updateAd(Ad ad);
	void deleteAd(Long adId);
}
