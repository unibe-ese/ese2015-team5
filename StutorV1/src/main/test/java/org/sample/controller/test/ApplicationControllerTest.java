package org.sample.controller.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.sample.controller.ApplicationController;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.UserService;
import org.sample.model.Application;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
@WebAppConfiguration
public class ApplicationControllerTest {

	@Autowired
	WebApplicationContext wac;
	
	@Mock
	UserService userService;
	
	@Mock 
	ApplicationService appService;
	
	@Mock
	MessageService messageService;
	
	Application testApplication,  controllApplication;

	
	@Mock
	Model model;
	
	private User currentUser, student, tutor;
	
	private ApplicationController appController;
	
	ArgumentCaptor<Application> captor;
	
	@Before
	public void setup(){
		initializeMocks();
		
		captor = ArgumentCaptor.forClass(Application.class);
		
		currentUser = new User();
		currentUser.setId((long)1);
		student = new User();
		currentUser.setId((long)2);
		tutor = new User();
		
		testApplication = new Application();
		testApplication.setStudent(student);
		testApplication.setTutor(tutor);
		
		 
		Mockito.when(appService.findApplicationById(any(long.class))).thenReturn(testApplication);
		Mockito.when(userService.getCurrentUser()).thenReturn(currentUser);
		Mockito.when(appService.deleteApplication(captor.capture())).thenReturn(null);
		Mockito.when(appService.acceptApplication(captor.capture())).thenReturn(null);
		
		}

	private void initializeMocks() {
		MockitoAnnotations.initMocks(this);	
		appController = new ApplicationController(userService, appService, messageService);
	}

	@Test
	public void injectionTest(){
		assertNotNull(appController);
	}
	
	@Test(expected=MockitoException.class)
	public void declineApplicationTest_NotOwner(){
		appController.declineApplication(5);
		assertEquals(student, testApplication.getStudent());
		assertEquals(tutor, testApplication.getTutor());
		System.out.println(captor.getValue());
	}
	
	@Test(expected=MockitoException.class)
	public void declineApplicationTest_Null(){
		Mockito.when(appService.findApplicationById(any(long.class))).thenReturn(null);
		testApplication.setTutor(currentUser);
		appController.declineApplication(5);
		captor.getValue();
		
	}
	
	@Test
	public void declineApplicationTest_Valid(){
		testApplication.setTutor(currentUser);
		appController.declineApplication(5);
		assertEquals(testApplication, captor.getValue());	
	}
	
	@Test
	public void declineApplicationTest_ReturnValue(){
		String returnedString = appController.declineApplication(5);
		assertEquals("redirect:/index", returnedString);
	}
	
	@Test(expected=MockitoException.class)
	public void acceptApplicationTest_NotOwner(){
		appController.acceptApplication(5);
		assertEquals(student, testApplication.getStudent());
		assertEquals(tutor, testApplication.getTutor());
		captor.getValue();
	}
	
	@Test(expected=MockitoException.class)
	public void acceptApplicationTest_Null(){
		Mockito.when(appService.findApplicationById(any(long.class))).thenReturn(null);
		testApplication.setTutor(currentUser);
		appController.acceptApplication(5);
		captor.getValue();
		
	}
	
	@Test
	public void acceptApplicationTest_Valid(){
		testApplication.setTutor(currentUser);
		appController.acceptApplication(5);
		assertEquals(testApplication, captor.getValue());	
	}
	
	@Test
	public void acceptApplicationTest_ReturnValue(){
		String returnedString = appController.acceptApplication(5);
		assertEquals("redirect:/index", returnedString);
	}
	
	
}
