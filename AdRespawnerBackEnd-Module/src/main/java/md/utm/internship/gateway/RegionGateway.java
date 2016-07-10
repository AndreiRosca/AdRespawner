package md.utm.internship.gateway;

import java.util.List;

import md.utm.internship.model.Region;

public interface RegionGateway {
	List<Region> getAllRegions();
	Region getRegionById(Long regionId);
	Region createRegion(Region region);
}
