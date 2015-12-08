package org.sample.controller.test;

import static org.junit.Assert.*;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.matchers.Any;
import org.sample.controller.TutorController;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.UserService;
import org.sample.model.Competence;
import org.sample.model.User;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
@WebAppConfiguration
public class TutorControllerTest {

	@Mock
	CompetenceService compService;
	
	@Mock
	UserService userService;
	
	@Mock
	CourseService courseService;
	
	@Mock
	Model model;
	
	@Mock 
	HttpSession session;
	
	@Mock
	BindingResult result;
	
	@Mock
	RedirectAttributes redirectAttributes;
	
	TutorController tutController;
	
	ArgumentCaptor<Competence> captor;
	
	ArgumentCaptor<AddCompetenceForm> formCaptor;

	private Competence testCompetence;

	private User currentUser;
	
	private AddCompetenceForm addCompetenceForm;
	
	private RedirectAttributesModelMap redirectModelMap;
	
	@Before
	public void setup(){
		initialiseMocks();
		
		redirectModelMap = new RedirectAttributesModelMap();
		
		currentUser = new User();
		currentUser.setId((long)666);
		
		captor = ArgumentCaptor.forClass(Competence.class);
		formCaptor = ArgumentCaptor.forClass(AddCompetenceForm.class);
		
		testCompetence = new Competence();
		
		addCompetenceForm = new AddCompetenceForm();
		addCompetenceForm.setDescription("");
		addCompetenceForm.setGrade("");
		
		Mockito.when(compService.findCompetenceById(Matchers.anyLong())).thenReturn(testCompetence);
		Mockito.when(compService.deleteCompetence(captor.capture())).thenReturn(null);
		Mockito.when(session.getAttribute("user")).thenReturn(currentUser);
		Mockito.when(result.hasErrors()).thenReturn(false);
		Mockito.when(compService.saveCompetence(formCaptor.capture())).thenReturn(null);
		
	}

	private void initialiseMocks() {
		MockitoAnnotations.initMocks(this);
		tutController = new TutorController(compService, courseService, userService);
	}
	
	@Test
	public void injectionTest(){
		assertNotNull(tutController);
	}
	
	@Test(expected=MockitoException.class)
	public void deleteCompetenceTest_Null(){
		Mockito.when(compService.findCompetenceById(Matchers.anyLong())).thenReturn(null);
		tutController.deleteCompetence(5);
		captor.getValue();
	}
	
	@Test
	public void deleteCompetenceTest(){
		tutController.deleteCompetence(5);
		assertEquals(testCompetence, captor.getValue());
	}
	
	@Test
	public void deleteCompetenceTest_ReturnValue(){
		assertEquals("redirect:/tutorProfile?tab=tab2", tutController.deleteCompetence(5));
	}
	
	@Test
	public void addCompetenceTest_WithErrors(){
		Mockito.when(result.hasErrors()).thenReturn(true);
		String returnString = tutController.addCompetence(addCompetenceForm, result, redirectModelMap, session);
		assertEquals("redirect:tutorProfile?tab=tab2", returnString);
		assertTrue(redirectModelMap.getFlashAttributes().containsKey("addCompetenceForm"));
		assertTrue(redirectModelMap.getFlashAttributes().containsKey("org.springframework.validation.BindingResult.addCompetenceForm"));
		
	}
	
	@Test
	public void addCompetenceTest_NoErrors(){
		Mockito.when(result.hasErrors()).thenReturn(false);
		String returnString = tutController.addCompetence(addCompetenceForm, result, redirectModelMap, session);
		assertEquals(addCompetenceForm, formCaptor.getValue());
		assertEquals("redirect:tutorProfile?tab=tab2", returnString);
	}
	
}
