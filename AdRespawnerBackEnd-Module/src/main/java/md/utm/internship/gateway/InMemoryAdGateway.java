package md.utm.internship.gateway;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.Ad;
import md.utm.internship.model.Currency;
import md.utm.internship.model.Price;
import md.utm.internship.model.Region;
import md.utm.internship.model.SubCategory;

@Repository
public class InMemoryAdGateway implements AdGateway {
	
	private ConcurrentMap<Long, Ad> ads = new ConcurrentHashMap<>();
	private AtomicLong idGenerator = new AtomicLong(0);
	
	public InMemoryAdGateway() {
		Ad first = new Ad("AMD Athlon II-X2 245, 250, 255, 280", "AMD Athlon II-X2 245 - 550lei 2.9GHz, 2MB L2 Cache, TDP 65W, Socket AM2/AM2+/AM3 AMD Athlon II-X2 250 - 550lei 3.0GHz, 2MB L2 Cache, TDP 65W, Socket AM2/AM2+/AM3 AMD Athlon II-X2 255 - 550lei 3.1GHz, 2MB L2 Cache, TDP 65W, Socket AM2/AM2+/AM", new Price(BigDecimal.TEN, Currency.MDL), new Region("Moldova", "mun. Chisinau"));
		SubCategory s1 = new SubCategory("Laptops", null);
		s1.setId(40L);
		SubCategory s2 = new SubCategory("Software", null);
		s2.setId(41L);
		SubCategory s3 = new SubCategory("HDD", null);
		s3.setId(42L);
		SubCategory s4 = new SubCategory("Projectors and Monitors", null);
		s4.setId(44L);
		createAd(first);
		Ad second = new Ad("Samsung SSD 850 PRO 1TB - 270 euro новыи в упаковке ", "Samsung SSD 850 PRO 1TB - 270 euro новыи в упаковке Samsung SSD 850 PRO 1TB Сайт производителя	www.samsung.com Технические спецификации	Форм-фактор	2,5", new Price(BigDecimal.TEN, Currency.MDL), new Region("Moldova", "mun. Chisinau"));
		second.setSubCategory(s3);
		first.setSubCategory(s1);
		createAd(second);
		Ad third = new Ad("Macbook Pro 2007", "Apple Macbook Pro 2007 with 4GB RAM, Intel core 2 duo processor", new Price(new BigDecimal(3000), Currency.MDL), new Region("Moldova", "Ungheni"));
		third.setSubCategory(s1);
		createAd(third);
	}

	@Override
	public List<Ad> getAllAds(Long categoryId) {
		return ads.values()
				  .stream()
				  .filter(a -> a.getSubCategory().getId().equals(categoryId))
				  .collect(Collectors.toList());
	}

	@Override
	public Ad getAd(Long adId) {
		return ads.get(adId);
	}

	@Override
	public Ad createAd(Ad ad) {
		ad.setId(idGenerator.incrementAndGet());
		ads.putIfAbsent(ad.getId(), ad);
		return ad;
	}

	@Override
	public Ad updateAd(Ad ad) {
		ad.setSubCategory(ads.get(ad.getId()).getSubCategory());
		ads.put(ad.getId(), ad);
		return ad;
	}

	@Override
	public void deleteAd(Long adId) {
		ads.remove(adId);
	}
}
