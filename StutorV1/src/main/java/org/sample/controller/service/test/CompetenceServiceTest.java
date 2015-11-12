package org.sample.controller.service.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.service.CompetenceService;
import org.sample.model.Competence;
import org.sample.model.User;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class CompetenceServiceTest {
	
	@Autowired
	CompetenceService compService;
	
	/**
	 *  Mocks 
	 */
	@Autowired CompetenceDao compDao;
	@Autowired UserDao userDao;
	
	private static User loggedin;
	
	private String competenceDescription = "Ballerness";
	private static boolean isUserEnabled = true;
	private static long userId = 333;
	
	@BeforeClass
	public static void setup(){
		loggedin= new User();
		loggedin.setEnableTutor(isUserEnabled);
		loggedin.setId(userId);
		
		
		
	}
	
	@Test
	public void injectionTest(){
		assertNotNull(compService);
		assertNotNull(compDao);
			
	}
	
	@Test
	public void addCompetenceTest(){
		when(compDao.save(any(Competence.class))).then(AdditionalAnswers.returnsFirstArg());
		when(userDao.findOne(any(Long.class))).thenReturn(loggedin);
		
		AddCompetenceForm form = new AddCompetenceForm();
		form.setDescription(competenceDescription);
		form.setOwnerId(666);
		
		Competence comp = compService.saveCompetence(form);
		assertEquals(competenceDescription, comp.getDescription());
		assertEquals(isUserEnabled, comp.getisEnabled());
		assertTrue(userId == comp.getOwner().getId());
	}
	

}
