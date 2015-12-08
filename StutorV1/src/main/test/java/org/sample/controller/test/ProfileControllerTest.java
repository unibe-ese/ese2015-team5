package org.sample.controller.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sample.controller.ProfileController;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.pojos.ModifyUserForm;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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
	
	private User userToEdit, testUser;
	
	private ModifyUserForm modForm;
	
	@Mock
	private BindingResult result;
	
	private ProfileController controller;
	
	private RedirectAttributesModelMap redirectModelMap;
	
	private ExtendedModelMap extendedModelMap;
	
	private Week testWeek;
	
	private long userId = (long)5;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		controller = new ProfileController(userService, compService, courseService, appService);
		
		redirectModelMap = new RedirectAttributesModelMap();
		extendedModelMap = new ExtendedModelMap();
		
		userToEdit = new User();
		userToEdit.setId((long)666);
		
		testUser = new User();
		
		testWeek = new Week();
		
		modForm = new ModifyUserForm();
		modForm.setPassword("hello");
		modForm.setPasswordControll("its mee");
		when(courseService.buildCalendar(any(Calendar.class), any(User.class))).thenReturn(testWeek);
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
	public void modifyUser_errors() throws InvalidUserException, UnsupportedEncodingException{
		Mockito.when(result.hasErrors()).thenReturn(true);
		String returnValue = controller.modifyUser(userToEdit, modForm, result, redirectModelMap);
		assertEquals("redirect:/tutorProfile?edit=fail", returnValue);
		assertNotNull(redirectModelMap.getFlashAttributes().get("modifyUserForm"));
		assertNotNull(redirectModelMap.getFlashAttributes().get("org.springframework.validation.BindingResult.modifyUserForm"));
	}
	
	@Test
	public void modifyUser_success() throws InvalidUserException, UnsupportedEncodingException{
		Mockito.when(result.hasErrors()).thenReturn(false);
		Mockito.when(userService.validateModifyUserForm(any(ModifyUserForm.class))).thenReturn(true);
		String returnValue= controller.modifyUser(userToEdit, modForm, result, redirectModelMap);
		assertEquals("redirect:/tutorProfile?edit=success", returnValue);
	}
	
	@Test
	public void modifyUser_notValid() throws InvalidUserException, UnsupportedEncodingException{
		Mockito.when(result.hasErrors()).thenReturn(false);
		Mockito.when(userService.validateModifyUserForm(any(ModifyUserForm.class))).thenReturn(false);
		String returnValue= controller.modifyUser(userToEdit, modForm, result, redirectModelMap);
		assertEquals("redirect:/index", returnValue);
	}
	
	@Test
	public void showPublicProfileTest_BothNull(){
		when(userService.getCurrentUser()).thenReturn(null);
		when(userService.getUserById(any(long.class))).thenReturn(null);
		String returnValue = controller.showPublicProfile((long)5, null, null);
		assertEquals("redirect:/index", returnValue);
	}
	
	@Test
	public void showPublicProfileTest_Equal(){
		when(userService.getCurrentUser()).thenReturn(testUser);
		when(userService.getUserById(any(long.class))).thenReturn(testUser);
		String returnValue = controller.showPublicProfile((long)5, null, null);
		assertEquals("redirect:/tutorProfile", returnValue);
	}
	
	@Test
	public void showPublicProfileTest_NotEqualNotContainWeek(){
		when(userService.getCurrentUser()).thenReturn(testUser);
		when(userService.getUserById(any(long.class))).thenReturn(userToEdit);
		String returnValue = controller.showPublicProfile((long)5, extendedModelMap, redirectModelMap);
		
		assertEquals(userToEdit, extendedModelMap.get("visitee"));
		assertTrue(extendedModelMap.containsAttribute("application"));
		assertTrue(extendedModelMap.containsAttribute("week"));
		assertTrue(extendedModelMap.containsAttribute("hours"));
		assertEquals("publicProfile", returnValue);
	}
	
	@Test
	public void showPublicProfileTest_ContainWeek(){
		when(userService.getCurrentUser()).thenReturn(testUser);
		when(userService.getUserById(any(long.class))).thenReturn(userToEdit);
		extendedModelMap.put("week", testWeek);
		
		controller.showPublicProfile((long)5, extendedModelMap, redirectModelMap);
		assertEquals(testWeek, extendedModelMap.get("week"));
	}
	
	@Test
	public void showPublicProfileNextWeekTest_NullUser(){
		when(userService.getUserById(any(long.class))).thenReturn(null);
		String returnValue = controller.showPublicProfileNextWeek(userId, null, null);
		assertEquals("redirect:/index", returnValue);
	}
	
	@Test
	public void showPublicProfileNextWeekTest_UnparsableDate(){
		when(userService.getUserById(any(long.class))).thenReturn(testUser);
		String returnValue = controller.showPublicProfileNextWeek(userId, "Blubbi", redirectModelMap);
		assertEquals("redirect:/tutorProfile/" + userId, returnValue);
		assertEquals(0, redirectModelMap.getFlashAttributes().keySet().size());
	}
	
	@Test
	public void showPublicProfileNextWeekTest_Valid(){
		when(userService.getUserById(any(long.class))).thenReturn(testUser);
		String returnValue = controller.showPublicProfileNextWeek(userId, "01.01.2000", redirectModelMap);
		assertEquals("redirect:/tutorProfile/" + userId, returnValue);
		assertEquals(1, redirectModelMap.getFlashAttributes().keySet().size());
		assertEquals(testWeek, redirectModelMap.getFlashAttributes().get("week"));
	}
	
	@Test
	public void showPublicProfileLastWeekTest_NullUser(){
		when(userService.getUserById(any(long.class))).thenReturn(null);
		String returnValue = controller.showPublicProfileLastWeek(userId, null, null);
		assertEquals("redirect:/index", returnValue);
	}
	
	@Test
	public void showPublicProfileLastWeekTest_UnparsableDate(){
		when(userService.getUserById(any(long.class))).thenReturn(testUser);
		String returnValue = controller.showPublicProfileLastWeek(userId, "Blubbi", redirectModelMap);
		assertEquals("redirect:/tutorProfile/" + userId, returnValue);
		assertEquals(0, redirectModelMap.getFlashAttributes().keySet().size());
	}
	
	@Test
	public void showPublicProfileLastWeekTest_Valid(){
		when(userService.getUserById(any(long.class))).thenReturn(testUser);
		String returnValue = controller.showPublicProfileLastWeek(userId, "01.01.2000", redirectModelMap);
		assertEquals("redirect:/tutorProfile/" + userId, returnValue);
		assertEquals(1, redirectModelMap.getFlashAttributes().keySet().size());
		assertEquals(testWeek, redirectModelMap.getFlashAttributes().get("week"));
	}
	
	
}