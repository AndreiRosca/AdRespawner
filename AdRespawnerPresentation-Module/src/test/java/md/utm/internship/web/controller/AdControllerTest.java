package md.utm.internship.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import md.utm.internship.config.RootConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfiguration.class })
public class AdControllerTest {

	@Autowired
	private AdController controller;
	private String adCategoryId = "1";
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testThatTheControllerPopulatesTheModelAndReturnsTheProperViewName() throws Exception {
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/ads/" + adCategoryId))
			   .andExpect(model().attributeExists("adList"))
			   .andExpect(view().name("adList"));
	}
}
