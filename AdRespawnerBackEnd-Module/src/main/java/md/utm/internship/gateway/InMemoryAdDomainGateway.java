package md.utm.internship.gateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.AdDomain;

//@Repository
public class InMemoryAdDomainGateway implements AdDomainGateway {
	
	private static ConcurrentMap<Long, AdDomain> adDomains = new ConcurrentHashMap<>();
	private static AtomicLong idGenerator = new AtomicLong(0);
	
	public InMemoryAdDomainGateway() {
		createAdDomain(new AdDomain("Computers and Office equipment"));
		createAdDomain(new AdDomain("Audio-Video-Photo"));
		createAdDomain(new AdDomain("Business"));
	}

	@Override
	public List<AdDomain> getAllAdDomains() {
		return adDomains.values()
						.stream()
						.collect(Collectors.toList());
	}

	@Override
	public AdDomain getAdDomain(Long id) {
		return adDomains.get(id);
	}

	@Override
	public void createAdDomain(AdDomain adDomain) {
		adDomain.setId(idGenerator.incrementAndGet());
		adDomains.putIfAbsent(adDomain.getId(), adDomain);
	}

	@Override
	public void updateAdDomain(AdDomain adDomain) {
		adDomains.put(adDomain.getId(), adDomain);
	}

	@Override
	public void deleteAdDomain(AdDomain adDomain) {
		adDomains.remove(adDomain.getId());
	}
}
