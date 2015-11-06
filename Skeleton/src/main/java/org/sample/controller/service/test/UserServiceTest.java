package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class UserServiceTest {


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
		testSignupForm.setProfilePic(new MockMultipartFile("testPic", byteArray));

		User testUser = testUserService.saveUser(testSignupForm);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(null, testUser.getPic());
	}
	
}
