package md.utm.internship.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class AdDomainResourceClient {

	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	public AdDomainResourceClient(String adDomainResourceUrl) {
		target = client.target(adDomainResourceUrl);
	}
	
	public List<AdDomain> getAllAdDomains() {
		return target.path("/adDomains")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<List<AdDomain>>() {});
	}
	
	public AdDomain getAdDomain(Long id) {
		return target.path("/adDomains/")
					 .path(id.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .get(new GenericType<AdDomain>() {});
	}
	
	public AdDomain createAdDomain(AdDomain adDomain) {
		return target.path("/adDomains")
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .post(Entity.json(adDomain), AdDomain.class);
	}
	
	public AdDomain updateAdDomain(Long id, AdDomain adDomain) {
		return target.path("/adDomains/")
					 .path(id.toString())
					 .request()
					 .accept(MediaType.APPLICATION_JSON)
					 .put(Entity.json(adDomain), AdDomain.class);
	}
	
	public void deleteAdDomain(Long id) {
		target.path("/adDomains/")
			  .path(id.toString())
			  .request()
			  .delete();
	}
	
	public void dispose() {
		client.close();
	}
}
