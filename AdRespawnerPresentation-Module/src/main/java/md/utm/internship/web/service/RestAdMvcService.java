package md.utm.internship.web.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import md.utm.internship.rest.client.AdResourceClient;
import md.utm.internship.rest.client.RegionResourceClient;
import md.utm.internship.rest.client.domain.Ad;
import md.utm.internship.rest.client.domain.Photo;
import md.utm.internship.rest.client.domain.Region;

public class RestAdMvcService implements AdMvcService {
	
	private AdResourceClient adResourceClient;
	private RegionResourceClient regionResourceClient;

	public RestAdMvcService(AdResourceClient adResourceClient, RegionResourceClient regionResourceClient) {
		this.adResourceClient = adResourceClient;
		this.regionResourceClient = regionResourceClient;
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

	@Override
	public List<Photo> moveUploadedAdPhotoFiles(String baseFolder, List<MultipartFile> adPhotos) {
		List<Photo> photos = new ArrayList<>();
		String targetFolder = "/resources/images/ad/";
		for (MultipartFile file : adPhotos) {
			String fileName = new Date().getTime() + "_" + file.getOriginalFilename();
			String relativePath = targetFolder + fileName;
			File fileSystemPath = new File(baseFolder + targetFolder + fileName);
			photos.add(new Photo(relativePath));
			try {
				file.transferTo(fileSystemPath);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return photos;
	}

	@Override
	public List<Region> getAllRegions() {
		return regionResourceClient.getAllRegions();
	}

	@Override
	public Region getRegionById(Long regionId) {
		return regionResourceClient.getRegionById(regionId);
	}

	@Override
	public Region createRegion(Region region) {
		return regionResourceClient.createRegion(region);
	}
}
