package md.utm.internship.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import md.utm.internship.rest.client.domain.Ad;

public class AdResourceClient {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	private String resourceUrl;
	
	public AdResourceClient(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	public List<Ad> getAllAds() {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<Ad>>() {});
	}

	public Ad getAd(Long adId) {
		return target.path(adId.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<Ad>() {});
	}
	
	public Ad createAd(Ad ad) {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(ad), Ad.class);
	}
	
	public void dispose() {
		client.close();
	}
	
	public void setAdSubcategoryId(Long subCategoryId) {
		target = client.target(resourceUrl + "/" + subCategoryId + "/ads/");
	}
}
