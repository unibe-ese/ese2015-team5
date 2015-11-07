package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sample.controller.pojos.RegistrationForm;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.springframework.mock.web.MockMultipartFile;

public class UserServiceTest {


	private UserService testUserService;

	@Test
	public void testSaveUser() throws Exception {
		
		byte[] byteArray = {0,1,0};
		
		MockMultipartFile testPic = new MockMultipartFile("file", byteArray);
		
		RegistrationForm testSignupForm = new RegistrationForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		testSignupForm.setProfilePic(new MockMultipartFile("testPic", byteArray));

		User testUser = testUserService.saveUser(testSignupForm);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(null, testUser.getPic());
	}
	
}
