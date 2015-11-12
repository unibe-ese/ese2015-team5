package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class UserServiceTest {

	@Autowired
	private UserService testUserService;
	@Autowired
	private UserDao testUserDao;

	private SignupForm testSignupForm;
	private MockMultipartFile testPic;
	
	@Before
	public void setUp()
	{
		byte[] byteArray = {0,1,0};
		
		testPic = new MockMultipartFile("file", byteArray);
		
		

		testSignupForm = new SignupForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		testSignupForm.setProfilePic(testPic);
	}
	
	@Test
	public void testSaveUser() throws Exception {
		
		
		User testUser = testUserService.saveUser(testSignupForm);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(testPic.getBytes(), testUser.getPic().getFile());
	}
	
/*	@Test
	public void testUpdateUser() throws InvalidUserException
	{
		User testUser = testUserService.saveUser(testSignupForm);
		
		
//		UserDao userDao = Mockito.mock(UserDao.class);
//		Mockito.when(userDao.findOne(Mockito.anyLong())).thenReturn(testUser);

		
		ModifyUserForm testForm = new ModifyUserForm();
		testForm.setAboutYou("Powerful Magician");
		testForm.setEnableTutor(true);
		testForm.setFirstName("Gandalf");
		testForm.setId(testUserService.getUserByEmail("ese@hs15.ch").getId());
		testForm.setLastName("Doe");
		testForm.setPassword("asdf");
		testForm.setPasswordControll("asdf");
		
		testUserService.updateUser(testForm);
		
		assertEquals("Powerful Magician", testUser.getAboutYou());
		assertEquals(true, testUser.getEnableTutor());
		assertEquals("Gandalf", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		
		testUserDao.delete(testUser);
	}*/
	
}
