package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	private Competence comp, comp2, comp3, comp4;
	private List<Competence> comps;
	
	private String competenceDescription = "Ballerness", competenceDescription2 = "Kickass",
			competenceDescription3 = "Blubbi", competenceDescription4 = "iRanOutOfNames",
			gradeString = "1";
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
		
		comp2 = new Competence();
		comp2.setDescription(competenceDescription2);
		comp2.setisEnabled(true);
		comp2.setId(333);
		
		comp3 = new Competence();
		comp3.setDescription(competenceDescription3);
		comp3.setisEnabled(false);
		comp3.setId(111);
		
		comp4 = new Competence();
		comp4.setDescription(competenceDescription4);
		comp4.setisEnabled(true);
		comp4.setId(999);
		
		List<Competence> comps = new ArrayList<Competence>();
		comps.add(comp);
		comps.add(comp2);
		comps.add(comp3);
		
		when(compDao.save(any(Competence.class))).then(AdditionalAnswers.returnsFirstArg());
		when(userDao.findOne(any(Long.class))).thenReturn(loggedin);
	}
	
	@Test
	public void injectionTest(){
		assertNotNull(compService);
		assertNotNull(compDao);		
	}
	
	@Test
	public void addCompetenceTest(){	
		AddCompetenceForm form = new AddCompetenceForm();
		
		form.setDescription(competenceDescription);
		form.setOwnerId(666);
		form.setGrade(gradeString);
		System.out.println(form.getGrade());
		
		Competence comp = compService.saveCompetence(form);
		assertEquals(competenceDescription, comp.getDescription());
		assertEquals(isUserEnabled, comp.getisEnabled());
		assertTrue(userId == comp.getOwner().getId());
		assertTrue(1.0 == comp.getGrade());
	}
	
	@Test
	public void addCompetenceTestNull(){	
		AddCompetenceForm form = new AddCompetenceForm();
		
		form.setDescription(competenceDescription);
		form.setOwnerId(666);
		form.setGrade(null);

		Competence comp = compService.saveCompetence(form);
		assertEquals(competenceDescription, comp.getDescription());
		assertEquals(isUserEnabled, comp.getisEnabled());
		assertTrue(userId == comp.getOwner().getId());
		assertTrue(0.0 == comp.getGrade());
	}
	
	@Test
	public void addCompetenceTestInvalidGrade(){	
		AddCompetenceForm form = new AddCompetenceForm();
		
		form.setDescription(competenceDescription);
		form.setOwnerId(666);
		form.setGrade(competenceDescription);

		Competence comp = compService.saveCompetence(form);

		assertEquals(competenceDescription, comp.getDescription());
		assertEquals(isUserEnabled, comp.getisEnabled());
		assertTrue(userId == comp.getOwner().getId());
		assertTrue(0.0 == comp.getGrade());
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
	
	@Test
	public void editCompetenceTestInvalid(){
		when(compDao.findOne(any(long.class))).thenReturn(null);
		EditCompetenceForm editForm = new EditCompetenceForm();
		editForm.setDescription(editCompetenceDescription);
		
		Competence editedComp = compService.updateCompetence(editForm);
		assertEquals(null, editedComp);
	}
	
	@Test
	public void findCompetenceLikeTest1(){
		comps = new ArrayList<Competence>();
		comps.add(comp);
		comps.add(comp2);
		comps.add(comp3);
		comps.add(comp4);
		when(compDao.findAll()).thenReturn(comps);
		List<Competence> competenceLike = compService.findCompetenceLike("b");
		
		assertTrue(competenceLike.contains(comp));
		assertFalse(competenceLike.contains(comp2));
		assertFalse(competenceLike.contains(comp3));
		assertFalse(competenceLike.contains(comp4));
	}
	

}
