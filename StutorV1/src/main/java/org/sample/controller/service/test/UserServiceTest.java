package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
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
	public void testUpdateUser() throws InvalidUserException
	{
		User testUser = new User();
		testUser.setAboutYou("'special' wizzard");
		testUser.setEmail("CastThatShit@Magiczz.ch");
		testUser.setFirstName("Gundolf");
		testUser.setEnableTutor(false);
		testUser.setLastName("the Grey");
		testUser.setPassword("fdsa");
		
		UserDao userDao = Mockito.mock(UserDao.class);
		Mockito.when(userDao.findOne(Mockito.anyLong())).thenReturn(testUser);

		
		ModifyUserForm testForm = new ModifyUserForm();
		testForm.setAboutYou("Powerful Magician");
		testForm.setEnableTutor(true);
		testForm.setFirstName("Gandalf");
		testForm.setId(0);
		testForm.setLastName("the White");
		testForm.setPassword("asdf");
		testForm.setPasswordControll("asdf");
		
		testUserService.updateUser(testForm);
		
		assertEquals("Powerful Magician", testUser.getAboutYou());
		assertEquals(true, testUser.getEnableTutor());
		assertEquals("Gandalf", testUser.getFirstName());
		assertEquals("the White", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		
		
		
		
		
		
	}
	
}
