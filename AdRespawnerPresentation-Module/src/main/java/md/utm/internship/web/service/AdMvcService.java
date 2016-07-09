package md.utm.internship.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import md.utm.internship.rest.client.domain.Ad;
import md.utm.internship.rest.client.domain.Photo;


public interface AdMvcService {
	List<Ad> getAllAds();
	Ad getAd(Long adId);
	void setAdSubResourceId(Long adSubResourceId);
	Ad createAd(Ad ad);
	List<Photo> moveUploadedAdPhotoFiles(String targetFolder, List<MultipartFile> adPhotos);
}
