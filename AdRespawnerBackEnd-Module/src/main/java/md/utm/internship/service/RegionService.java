package md.utm.internship.service;

import java.util.List;

import md.utm.internship.model.Region;

public interface RegionService {
	List<Region> getAllRegions();
	Region getRegionById(Long regionId);
	Region createRegion(Region region);
}
