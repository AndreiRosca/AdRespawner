package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import md.utm.internship.model.AdDomain;
import md.utm.internship.service.AdDomainService;

@Path("/adDomains")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class AdDomainResource {

	@Autowired
	private AdDomainService adDomainService;

	@GET
	public List<AdDomain> getAllAdDomains() {
		return adDomainService.getAllAdDomains();
	}

	@GET
	@Path("{id}")
	public AdDomain getAdDomain(@PathParam("id") Long id) {
		return adDomainService.getAdDomain(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public AdDomain createAdDomain(AdDomain adDomain) {
		adDomainService.createAdDomain(adDomain);
		return adDomain;
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public AdDomain updateAdDomain(@PathParam("id") Long id, AdDomain adDomain) {
		adDomain.setId(id);
		adDomainService.updateAdDomain(adDomain);
		return adDomain;
	}

	@DELETE
	@Path("{id}")
	public void deleteAdDomain(@PathParam("id") Long id) {
		AdDomain adDomain = adDomainService.getAdDomain(id);
		adDomainService.deleteAdDomain(adDomain);
	}
}
