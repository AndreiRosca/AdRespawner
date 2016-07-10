package md.utm.internship.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import md.utm.internship.config.RootConfiguration;
import md.utm.internship.web.service.AdMvcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfiguration.class })
public class AdControllerTest {

	@Autowired
	private AdController controller;
	private AdMvcService service;
	private String adCategoryId = "1";
	
	@Before
	public void setUp() {
		service = mock(AdMvcService.class);
		when(service.getAllAds()).thenReturn(Collections.emptyList());
		controller.setAdMvcService(service);
	}
	
	@Test
	public void testThatTheControllerPopulatesTheModelAndReturnsTheProperViewName() throws Exception {
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/ads/" + adCategoryId))
			   .andExpect(model().attributeExists("adList"))
			   .andExpect(view().name("adList"));
		verify(service).getAllAds();
	}
}
