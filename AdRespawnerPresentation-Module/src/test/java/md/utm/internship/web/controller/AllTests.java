package md.utm.internship.web.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdControllerTest.class, CategoryControllerTest.class,
				HomePageControllerTest.class, UserControllerTest.class })
public class AllTests {

}
