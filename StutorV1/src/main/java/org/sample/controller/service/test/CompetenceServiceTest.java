package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.CompetenceService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/test.xml" })
public class CompetenceServiceTest {

	@Autowired
	private CompetenceService testCompetenceService;
	
	

}
