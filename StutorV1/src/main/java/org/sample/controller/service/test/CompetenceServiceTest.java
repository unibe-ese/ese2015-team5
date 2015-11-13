package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.EditCompetenceForm;
import org.sample.controller.service.CompetenceService;
import org.sample.model.Competence;
import org.sample.model.User;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	private User loggedin;
	private Competence comp;
	
	private String competenceDescription = "Ballerness";
	private String editCompetenceDescription = "JipJip";
	private boolean isUserEnabled = true;
	private long userId = 333;
	private long randId = 123;
	
	@BeforeClass
	public static void setup(){
		
	
	}
	
	@Before
	public void classicSetup(){
		loggedin= new User();
		loggedin.setEnableTutor(isUserEnabled);
		loggedin.setId(userId);
		
		comp = new Competence();
		comp.setDescription(competenceDescription);
		comp.setId(randId);
		comp.setisEnabled(isUserEnabled);
		comp.setOwner(loggedin);
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
	
	@Test
	public void editCompetenceTest(){
		
	
		when(compDao.findOne(any(long.class))).thenReturn(comp);
		
		EditCompetenceForm editForm = new EditCompetenceForm();
		editForm.setDescription(editCompetenceDescription);
		
		Competence editedComp = compService.updateCompetence(editForm);
		assertEquals(editCompetenceDescription, editedComp.getDescription());
		assertEquals(randId, editedComp.getId());
		assertEquals(isUserEnabled, editedComp.getisEnabled());
		assertTrue(userId == editedComp.getOwner().getId());
		
	}
	

}
