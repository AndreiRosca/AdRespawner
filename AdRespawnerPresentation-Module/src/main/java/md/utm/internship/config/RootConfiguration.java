package md.utm.internship.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import md.utm.internship.rest.client.AdDomainResourceClient;
import md.utm.internship.web.service.AdDomainMvcService;
import md.utm.internship.web.service.BasicAdDomainMvcService;

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
		return new BasicAdDomainMvcService(client);
	}
}
