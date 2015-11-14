package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.UserService;
import org.sample.model.Competence;
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
	
	@Captor
	private ArgumentCaptor<User> captor;

	private User user, ecpectedUser;
	private SignupForm testSignupForm;
	private ModifyUserForm testForm;
	private MockMultipartFile testPic;
	
	private byte[] byteArray2 = {1, 0, 1};
	
	long newID = 111;
	
	@Before
	public void setUp()
	{
		byte[] byteArray = {0,1,0};
		
		
		testPic = new MockMultipartFile("file", byteArray);
		testPic = new MockMultipartFile("otherFile", byteArray2);
		//captor = ArgumentCaptor.forClass(SignupForm.class);
		captor = ArgumentCaptor.forClass(User.class);

		testSignupForm = new SignupForm();
		testSignupForm.setEmail("ese@hs15.ch");
		testSignupForm.setFirstName("John");
		testSignupForm.setLastName("Doe");
		testSignupForm.setPassword("asdf");
		testSignupForm.setProfilePic(testPic);
		
		testForm = new ModifyUserForm();
		testForm.setAboutYou("Powerful Magician");
		testForm.setEnableTutor(true);
		testForm.setFirstName("Gandalf");
		testForm.setLastName("Doe");
		testForm.setPassword("fdsa");
		testForm.setPasswordControll("fdsa");
		
		user = new User();
		user.setEmail("ese@hs15.ch");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("asdf");
		List<Competence> comps = new ArrayList<Competence>();
		user.setCompetences(comps);
		user.setEnableTutor(false);
		
		ecpectedUser = new User();
		ecpectedUser.setAboutYou("Powerful Magician");
		ecpectedUser.setEnableTutor(true);
		ecpectedUser.setFirstName("Gandalf");
		ecpectedUser.setLastName("Doe");
		ecpectedUser.setPassword("fdsa");
		
		when(testUserDao.findOne(any(Long.class))).thenReturn(user);
		when(testUserDao.save(captor.capture())).thenReturn(null);
		
	}
	
	@Test
	public void testSaveUser() throws Exception {
		
		
		User testUser = testUserService.saveUser(testSignupForm);
		
		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(testPic.getBytes(), testUser.getPic().getFile());
		
		assertEquals(user, captor.getValue());
		
	}
	
	@Test
	public void testUpdateUser() throws InvalidUserException
	{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		
		User modifiedUser = testUserService.updateUser(testForm);
		assertEquals(ecpectedUser, modifiedUser);
		
	}
	
	@Test
	public void testValidateModifyUserFormWCorrect(){
		assertTrue(testUserService.validateModifyUserForm(testForm));
	}
	
	@Test
	public void testValidateModifyUserFormWInorrect(){
		testForm.setPasswordControll("something Else");
		assertFalse(testUserService.validateModifyUserForm(testForm));
	}
	
//	@Test
//	public void testUpdateProfilePicture(){
//		Authentication auth = new UsernamePasswordIDAuthenticationToken(user.getId(), null, null, null);
//		SecurityContextHolder.getContext().setAuthentication(auth);
//		ProfilePicture pic = new ProfilePicture();
//		pic.setFile(byteArray2);
//		testUserService.updateProfilePicture(pic);
//		assertEquals(byteArray2, user.getPic().getFile());
//	}

}
