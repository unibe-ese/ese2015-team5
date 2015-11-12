package org.sample.controller.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.service.CompetenceService;
import org.sample.model.dao.CompetenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/test.xml")
@WebAppConfiguration
@Rollback(true)
public class CompetenceServiceTest {
	
	@Autowired
	CompetenceService compService;
	@Autowired CompetenceDao compDao;
	
	@BeforeClass
	public static void setup(){
		
	}
	
	@Test
	public void testTest(){
		assertNotNull(compService);
		assertNotNull(compDao);
	}
	

}
