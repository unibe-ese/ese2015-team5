package org.sample.controller.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.controller.ProfileController;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.sample.model.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
@WebAppConfiguration
public class ProfileControllerTest {
	
	@Autowired
	WebApplicationContext wac;
	
	@Mock
	private UserService userService;
	@Mock
	private CompetenceService compService;
	@Mock 
	private CourseService courseService;
	@Mock
	private ApplicationService appService;
	@Mock
	private Model model;
	@Mock
	private User user;
	
	private ProfileController controller;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		controller = new ProfileController(userService, compService, courseService, appService);
	}
	
	@Test
	public void getProfile_getProfilePage_loggedInAsStudent(){
		when(userService.getCurrentUser()).thenReturn(user);
		when(user.getEnableTutor()).thenReturn(false);
		ModelAndView view = controller.gotoProfile(model);
		assertEquals("generalProfile", view.getViewName());	
	}
	
	@Test
	public void getProfile_getProfilePage_loggedInAsTutor(){
		when(userService.getCurrentUser()).thenReturn(user);
		when(user.getEnableTutor()).thenReturn(true);
		ModelAndView view = controller.gotoProfile(model);
		assertEquals("tutorProfile", view.getViewName());
	}
	
	@Test
	public void getProfile_getProfilePage_notLoggedIn(){
		when(userService.getCurrentUser()).thenReturn(null);
		ModelAndView view = controller.gotoProfile(model);
		assertEquals("index", view.getViewName());
	}
	
	@Test
	public void getProfile_getProfileModel_noAttributesAssigned(){
		ExtendedModelMap mymodel = new ExtendedModelMap();
		when(userService.getCurrentUser()).thenReturn(user);
		ModelAndView view = controller.gotoProfile(mymodel);
		assertTrue(view.getModel().containsKey("user"));
		assertTrue(view.getModel().containsKey("modifyUserForm"));
		assertTrue(view.getModel().containsKey("addCompetenceForm"));
		assertTrue(view.getModel().containsKey("week"));
		assertTrue(view.getModel().containsKey("hours"));
		assertTrue(view.getModel().containsKey("addCourseForm"));
	}
	
	@Test
	public void getProfile_getProfileModel_allAttributesAlreadyAssigned(){
		String key1 = "modifyUserForm",
				key2 = "week",
				key3 = "addCompetenceForm",
				object1 = "hy",
				object2 = "hello",
				object3 = "whatup";
		ExtendedModelMap mymodel = new ExtendedModelMap();
		mymodel.addAttribute(key1, object1);
		mymodel.addAttribute(key2, object2);
		mymodel.addAttribute(key3, object3);
		when(userService.getCurrentUser()).thenReturn(user);
		ModelAndView view = controller.gotoProfile(mymodel);
		assertEquals(object1, view.getModel().get(key1));
		assertEquals(object2, view.getModel().get(key2));
		assertEquals(object3, view.getModel().get(key3));
	}
	
	
	@Test
	public void modifyUser_success(){
		
	}
	
	public void modifyUser_failure(){
		
	}
}