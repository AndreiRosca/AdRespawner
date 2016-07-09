package md.utm.internship.web.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import md.utm.internship.config.RootConfiguration;
import md.utm.internship.web.service.CategoryMvcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfiguration.class })
public class CategoryControllerTest {

	@Autowired
	private CategoryController controller;
	private CategoryMvcService categoryService;
	private Long adDomainId = 1L;
	
	@Before
	public void setUp() {
		categoryService = mock(CategoryMvcService.class);
		when(categoryService.getAllCategories(adDomainId)).thenReturn(Collections.emptyList());
		controller.setCategoryMvcService(categoryService);
	}
	
	@Test
	public void testThatTheControllerPopulatesTheModelAndReturnsTheProperView() throws Exception {
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/category/" + adDomainId))
			   .andExpect(model().attributeExists("categoryList"))
			   .andExpect(view().name("category"));
		verify(categoryService).getAllCategories(adDomainId);
	}
}
