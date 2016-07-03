package md.utm.internship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import md.utm.internship.rest.client.AdDomainResourceClient;
import md.utm.internship.rest.client.AdResourceClient;
import md.utm.internship.rest.client.CategoryResourceClient;
import md.utm.internship.web.service.AdDomainMvcService;
import md.utm.internship.web.service.AdMvcService;
import md.utm.internship.web.service.CategoryMvcService;
import md.utm.internship.web.service.RestAdDomainMvcService;
import md.utm.internship.web.service.RestAdMvcService;
import md.utm.internship.web.service.RestCategoryMvcService;

@Configuration
@ComponentScan(basePackages = "md.utm.internship", 
	excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfiguration {

	@Bean(destroyMethod = "dispose")
	public AdDomainResourceClient adDomainResourceClient() {
		String resourceUrl = "http://localhost:8080/AdRespawnerWebService-Module/rest";
		AdDomainResourceClient client = new AdDomainResourceClient(resourceUrl);
		return client;
	}
	
	@Bean
	public AdDomainMvcService adDomainMvcService(AdDomainResourceClient client) {
		return new RestAdDomainMvcService(client);
	}
	
	@Bean(destroyMethod = "dispose")
	public CategoryResourceClient categoryResourceClient() {
		String resourceUrl = "http://localhost:8080/AdRespawnerWebService-Module/rest/adDomains";
		CategoryResourceClient client = new CategoryResourceClient(resourceUrl);
		return client;
	}
	
	@Bean
	public CategoryMvcService categoryMvcService(CategoryResourceClient categoryResource) {
		return new RestCategoryMvcService(categoryResource);
	}
	
	@Bean(destroyMethod = "dispose")
	public AdResourceClient adRsourceClient() {
		String resourceUrl = "http://localhost:8080/AdRespawnerWebService-Module/rest/subCategories";
		AdResourceClient client = new AdResourceClient(resourceUrl);
		return client;
	}
	
	@Bean
	public AdMvcService adMvcService(AdResourceClient client) {
		return new RestAdMvcService(client);
	}
}
