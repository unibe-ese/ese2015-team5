package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

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
public class UserServiceTest {

	@Autowired
	private UserService testUserService;

	@Test
	public void testSaveUser() throws Exception {
		
		byte[] byteArray = {0,1,0};
		
		MockMultipartFile testPic = new MockMultipartFile("file", byteArray);
		
		SignupForm testSignupForm = new SignupForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		testSignupForm.setProfilePic(testPic);

		User testUser = testUserService.saveUser(testSignupForm);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(testPic.getBytes(), testUser.getPic().getFile());
	}
	
	@Test
	public void testUpdateUser(){
		
	}
	
}
