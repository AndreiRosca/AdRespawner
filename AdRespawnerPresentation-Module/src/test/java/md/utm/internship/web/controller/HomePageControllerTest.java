package md.utm.internship.web.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import md.utm.internship.config.RootConfiguration;
import md.utm.internship.web.service.AdDomainMvcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfiguration.class })
public class HomePageControllerTest {

	@Autowired
	private HomePageController controller;
	private AdDomainMvcService adDomainService;
	
	@Before
	public void setUp() {
		adDomainService = mock(AdDomainMvcService.class);
		when(adDomainService.getAllAdDomains()).thenReturn(Collections.emptyList());
		controller.setAdDomainMvcService(adDomainService);
	}
	
	@Test
	public void testThatHomePageControllerPopulatesTheModelAndReturnsTheProperView() throws Exception {
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/"))
			   .andExpect(model().attributeExists("adDomainList"))
			   .andExpect(view().name("index"));
		verify(adDomainService).getAllAdDomains();
	}
}
