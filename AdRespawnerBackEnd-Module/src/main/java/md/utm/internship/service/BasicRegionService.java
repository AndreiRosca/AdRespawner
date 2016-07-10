package md.utm.internship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import md.utm.internship.gateway.RegionGateway;
import md.utm.internship.model.Region;

@Service
public class BasicRegionService implements RegionService {

	@Autowired
	private RegionGateway regionGateway;
	
	@Override
	public List<Region> getAllRegions() {
		return regionGateway.getAllRegions();
	}

	@Override
	public Region getRegionById(Long regionId) {
		return regionGateway.getRegionById(regionId);
	}

	@Override
	public Region createRegion(Region region) {
		return regionGateway.createRegion(region);
	}
}
