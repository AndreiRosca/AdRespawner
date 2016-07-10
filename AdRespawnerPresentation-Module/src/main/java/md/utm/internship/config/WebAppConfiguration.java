package md.utm.internship.config;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import md.utm.internship.web.consumer.FreshAdConsumer;
import md.utm.internship.web.converter.StringToContactConverter;
import md.utm.internship.web.converter.StringToPriceConverter;
import md.utm.internship.web.converter.StringToRegionConverter;
import md.utm.internship.web.converter.StringToSubCategoryConverter;
import md.utm.internship.web.decoder.JacksonJsonDecoder;
import md.utm.internship.web.decoder.JsonDecoder;
import md.utm.internship.web.listener.FreshAdListener;
import md.utm.internship.web.service.CategoryMvcService;
import md.utm.internship.web.websocket.WebSocketCategoryFreshAdConsumer;
import md.utm.internship.web.websocket.WebSocketFreshAdConsumer;

@Configuration
@EnableWebMvc
@ComponentScan("md.utm.internship.web")
public class WebAppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		return resolver;
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		resolver.setDefaultViews(Arrays.asList(jsonView));
		return resolver;
	}
	
	@Bean
	public JsonDecoder jacksonJsonDecoder() {
		return new JacksonJsonDecoder();
	}
	
	@Bean
	public FreshAdConsumer webSocketFreshAdConsumer(FreshAdListener listener) {
		FreshAdConsumer consumer = new WebSocketFreshAdConsumer();
		listener.addConsumer(consumer);
		return consumer;
	}
	
	@Bean
	public FreshAdConsumer webSocketCategoryFreshAdConsumer(JsonDecoder decoder, 
			CategoryMvcService service, FreshAdListener listener) {
		FreshAdConsumer consumer = new WebSocketCategoryFreshAdConsumer(decoder, service);
		listener.addConsumer(consumer);
		return consumer;
	}
	
	@Bean(destroyMethod = "dispose")
	public FreshAdListener freshAdListener() {
		return new FreshAdListener();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToContactConverter());
		registry.addConverter(new StringToSubCategoryConverter(applicationContext.getBean(CategoryMvcService.class)));
		registry.addConverter(new StringToPriceConverter());
		registry.addConverter(new StringToRegionConverter());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
