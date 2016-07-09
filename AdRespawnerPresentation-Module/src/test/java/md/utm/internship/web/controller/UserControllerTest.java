package md.utm.internship.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import md.utm.internship.config.RootConfiguration;
import md.utm.internship.web.service.UserMvcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfiguration.class })
public class UserControllerTest {

	@Autowired
	private UserController controller;
	
	@Autowired
	private UserMvcService userService;
	
	@Test
	public void nothing() {

		
	}
}
