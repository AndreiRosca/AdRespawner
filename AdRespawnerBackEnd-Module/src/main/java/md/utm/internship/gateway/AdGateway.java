package md.utm.internship.gateway;

import java.util.List;

import md.utm.internship.model.Ad;

public interface AdGateway {
	List<Ad> getAllAds(Long categoryId);
	Ad getAd(Long adId);
	Ad createAd(Ad ad);
	Ad updateAd(Ad ad);
	void deleteAd(Long adId);
}
