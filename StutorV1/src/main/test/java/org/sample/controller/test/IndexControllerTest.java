package org.sample.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sample.controller.IndexController;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
@WebAppConfiguration
public class IndexControllerTest {
	
	@Autowired
	WebApplicationContext wac;

	@Mock
	private CompetenceService compService;
	@Mock
	private UserService userService;
	@Mock
	private ApplicationService appService;
	@Mock
	private Model model;
	
	private IndexController controller;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		controller = new IndexController(compService, userService, appService);
	}
	
	
	@Test
	public void getIndex_returnIndexPage(){
		ModelAndView view = controller.index(model);
		assertEquals("index", view.getViewName());
	}
	
	@Test
	public void getIndex_addCompetencesAttributeIfNotAlreadyAdded(){
		when(model.containsAttribute("competences")).thenReturn(false);
		
		ModelAndView view = controller.index(model);
		assertNotNull(view.getModel().get("competences"));
	}
	
	@Test
	public void getIndex_dontAddCompetencesAttributeIfAlreadyAdded(){
		String key = "competences";
		String object = "test";
		Map <String, Object> map = new HashMap<String, Object>();
		map.put(key, object);
		when(model.asMap()).thenReturn(map);
		when(model.containsAttribute("competences")).thenReturn(true);
		
		ModelAndView view = controller.index(model);
		
		assertTrue(view.getModelMap().containsAttribute("competences"));
		assertEquals(object, view.getModel().get("competences"));
	}
	
	@Test
	public void getIndex_addApplicationsAndNewsFeed(){
		ModelAndView view = controller.index(model);
		assertNotNull(view.getModel().get("applications"));
		assertNotNull(view.getModel().get("newsfeed"));
	}
	
	
	
	

	// http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/

//	@Test
//	public void index_ShouldReturnIndexPage() throws Exception {
//		Competence first = new Competence();
//		first.setDescription("TestEse");
//		first.setGrade(5);
//		first.setId(1);
//		first.setisEnabled(true);
//		first.setOwner(null);
//
//		Competence second = new Competence();
//		second.setDescription("TestEse2");
//		second.setGrade(4);
//		second.setId(2);
//		second.setisEnabled(false);
//		second.setOwner(null);
//
//		when(compServiceMock.findCompetenceLike("")).thenReturn(
//				Arrays.asList(first, second));
//
//		mockMvc.perform(get("/", "/index"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("/index"))
//				.andExpect(forwardedUrl("/webapp/pages/index.jsp"))
//				.andExpect(model().attribute("competences", hasSize(2)))
//				.andExpect(
//						model().attribute(
//								"competences",
//								hasItem(allOf(
//										hasProperty("id", is(1)),
//										hasProperty("description",
//												is("TestEse")),
//										hasProperty("grade", is(5)),
//										hasProperty("isEnabled", is(true))))))
//				.andExpect(
//						model().attribute(
//								"competences",
//								hasItem(allOf(
//										hasProperty("id", is(2)),
//										hasProperty("description",
//												is("TestEse2")),
//										hasProperty("grade", is(4)),
//										hasProperty("isEnabled", is(false))))));
//
//		verify(compServiceMock, times(1)).findCompetenceLike("");
//		verifyNoMoreInteractions(compServiceMock);
//
//	}
//
//	@Test
//	public void goToImpressum_ShouldRenderImpressumView() throws Exception {
//
//		mockMvc.perform(get("/impressum")).andExpect(status().isOk())
//				.andExpect(forwardedUrl("/pages/impressum.jsp"));
//	}

}
