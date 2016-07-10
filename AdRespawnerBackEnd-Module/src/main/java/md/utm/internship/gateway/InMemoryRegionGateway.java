package md.utm.internship.gateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.Region;

@Repository
public class InMemoryRegionGateway implements RegionGateway {

	private static ConcurrentMap<Long, Region> regions = new ConcurrentHashMap<>();
	private static AtomicLong idGenerator = new AtomicLong(0);
	
	public InMemoryRegionGateway() {
		createRegion(new Region("Moldova", "Chisinau"));
		createRegion(new Region("Moldova", "Balti"));
		createRegion(new Region("Moldova", "Tiraspol"));
		createRegion(new Region("Moldova", "Cahul"));
		createRegion(new Region("Moldova", "Bender"));
		createRegion(new Region("Moldova", "Briceni"));
		createRegion(new Region("Moldova", "Basarabeasca"));
	}
	
	@Override
	public List<Region> getAllRegions() {
		return regions.values()
					  .stream()
					  .collect(Collectors.toList());
	}

	@Override
	public Region getRegionById(Long regionId) {
		return regions.get(regionId);
	}

	@Override
	public Region createRegion(Region region) {
		region.setId(idGenerator.incrementAndGet());
		regions.putIfAbsent(region.getId(), region);
		return region;
	}
}
