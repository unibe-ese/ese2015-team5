package org.sample.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
 
import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.sample.controller.service.CompetenceService;
import org.sample.model.Competence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
@WebAppConfiguration
public class IndexControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	private CompetenceService compServiceMock;
	

    @Before
    public void setup() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
    // http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
    
   
    
    @Test
    public void index_ShouldReturnIndexPage() throws Exception
    {
    	Competence first = new Competence();
    	first.setDescription("TestEse");
    	first.setGrade(5);
    	first.setId(1);
    	first.setisEnabled(true);
    	first.setOwner(null);
    	
    	Competence second = new Competence();
    	second.setDescription("TestEse2");
    	second.setGrade(4);
    	second.setId(2);
    	second.setisEnabled(false);
    	second.setOwner(null);
    	
    	when(compServiceMock.findCompetenceLike("")).thenReturn(Arrays.asList(first, second));
    	
    	mockMvc.perform(get("/", "/index"))
    		.andExpect(status().isOk())
    		.andExpect(view().name("/index"))
    		.andExpect(forwardedUrl("/webapp/pages/index.jsp"))
    		.andExpect(model().attribute("competences", hasSize(2)))
    		.andExpect(model().attribute("competences", hasItem(
    				allOf(
    						hasProperty("id", is(1)),
    						hasProperty("description", is("TestEse")),
    						hasProperty("grade", is(5)),
    						hasProperty("isEnabled", is(true))
    				)
    		)))
    		.andExpect(model().attribute("competences", hasItem(
    				allOf(
    						hasProperty("id", is(2)),
    						hasProperty("description", is("TestEse2")),
    						hasProperty("grade", is(4)),
    						hasProperty("isEnabled", is(false))
    				)
    		)));
    	
    	verify(compServiceMock, times(1)).findCompetenceLike("");
    	verifyNoMoreInteractions(compServiceMock);
    				
    				
    				
    
    }
    
    
    
	
	 @Test
	 public void goToImpressum_ShouldRenderImpressumView() throws Exception 
	 {
		 
		 mockMvc.perform(get("/impressum"))
		 	.andExpect(status().isOk())
		 	.andExpect(forwardedUrl("/pages/impressum.jsp"))
		 	;		 
	 }
	 
	 
	 

}
