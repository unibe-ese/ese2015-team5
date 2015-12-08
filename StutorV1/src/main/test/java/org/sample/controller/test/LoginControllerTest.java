package org.sample.controller.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
@WebAppConfiguration
public class LoginControllerTest {
	
	@Autowired
	WebApplicationContext wac;

	
	private ModelMap model = new ModelMap();
	
	private LoginController controller;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		controller = new LoginController();
	}
	
	@Test
	public void getLogin_returnLoginPage(){
		ModelAndView view = controller.getLoginPage(true, model);
		assertEquals("login", view.getViewName());
	}
	
	@Test
	public void getLogin_addNoErrorMessageOnNoError(){
		ModelAndView view = controller.getLoginPage(false, model);
		assertTrue(model.containsKey("error"));
		assertNull(model.get("error"));
	}
	
	@Test
	public void getLogin_addErrorMessageOnError(){
		ModelAndView view = controller.getLoginPage(true, model);
		assertTrue(model.containsKey("error"));
		assertNotNull(model.get("error"));
	}
}