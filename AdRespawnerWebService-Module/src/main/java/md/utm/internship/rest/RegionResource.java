package md.utm.internship.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import md.utm.internship.model.Region;
import md.utm.internship.service.RegionService;

@Path("/regions")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RegionResource {

	@Autowired
	private RegionService regionService;
	
	@GET
	public List<Region> getAllRegions() {
		return regionService.getAllRegions();
	}
	
	@GET
	@Path("{id}")
	public Region getRegion(@PathParam("id") Long regionId) {
		return regionService.getRegionById(regionId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Region createRegion(Region region) {
		return regionService.createRegion(region);	
	}
}
