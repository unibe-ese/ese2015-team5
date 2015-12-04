package org.sample.controller.service.test;

import org.junit.runner.RunWith;
import org.sample.model.dao.ApplicationDao;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class ApplicationServiceTest {

	@Autowired 
	ApplicationDao appDao;
	
}
