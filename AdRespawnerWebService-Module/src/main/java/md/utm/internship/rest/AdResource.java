package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import md.utm.internship.model.Ad;
import md.utm.internship.rest.listener.FreshAdListener;
import md.utm.internship.service.AdService;

@Path("/subCategories/{id}/ads")
public class AdResource {

	@Autowired
	private AdService adService;
	
	@Autowired
	private FreshAdListener freshAdListener;

	@GET
	public List<Ad> getAllAds(@PathParam("id") Long subCategoryId) {
		return adService.getAllAds(subCategoryId);
	}
	
	@GET
	@Path("{adId}")
	public Ad getAd(@PathParam("adId") Long adId) {
		return adService.getAd(adId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Ad createAd(Ad ad) {
		Ad newAd = adService.createAd(ad);
		freshAdListener.adCreated(newAd);
		return newAd;
	}
	
	@PUT
	@Path("{adId}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Ad updateAd(@PathParam("adId") Long id, Ad ad) {
		ad.setId(id);
		return adService.updateAd(ad);
	}
	
	@DELETE
	@Path("{adId}")
	public void deleteAd(@PathParam("adId") Long adId) {
		adService.deleteAd(adId);
	}
}
