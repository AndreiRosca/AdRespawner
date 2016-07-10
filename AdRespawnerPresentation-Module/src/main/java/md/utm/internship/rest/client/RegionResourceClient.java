package md.utm.internship.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import md.utm.internship.rest.client.domain.Region;

public class RegionResourceClient {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	public RegionResourceClient(String resourceUrl) {
		target = client.target(resourceUrl);
	}
	
	public List<Region> getAllRegions() {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<Region>>() {});
	}
	
	public Region getRegionById(Long regionId) {
		return target.path(regionId.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<Region>() {});
	}
	
	public Region createRegion(Region region) {
		return target.request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(region), Region.class);
	}
	
	public void dispose() {
		client.close();
	}
}
