package org.sample.controller.exceptions.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class InvalidUserExceptionTest {

	@Autowired
	private UserService testUserService;

	@Test
	public void testInvalidUserException() throws Exception {
		
		byte[] byteArray = {0,1,0};
		
		MockMultipartFile testPic = new MockMultipartFile("file", byteArray);
		
		SignupForm testSignupForm = new SignupForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		testSignupForm.setProfilePic(testPic);

		User testUser = testUserService.saveUser(testSignupForm);
	}
	
	
}
