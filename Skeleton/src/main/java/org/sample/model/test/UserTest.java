package org.sample.model.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.User;

public class UserTest {
	
	@Test
	public void testUserBuild() {
		
		SignupForm testSignupForm = new SignupForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		
		User testUser = new User(testSignupForm, null);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(null, testUser.getPic());
		
		
	}
	
	
}
