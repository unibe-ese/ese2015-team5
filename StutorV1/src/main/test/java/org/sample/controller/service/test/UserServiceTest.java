package org.sample.controller.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
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
	
	private float houerlyRate = (float) 5.0;
	
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
		for(int i = 0; i < 3; i++){
			Competence comp = new Competence();
			comp.setisEnabled(false);
			comps.add(comp);
		}
		user.setCompetences(comps);
		user.setEnableTutor(false);
		
		ecpectedUser = new User();
		ecpectedUser.setAboutYou("Powerful Magician");
		ecpectedUser.setEnableTutor(true);
		ecpectedUser.setFirstName("Gandalf");
		ecpectedUser.setLastName("Doe");
		ecpectedUser.setPassword("fdsa");
		
		User someUser = new User();
		someUser.setEmail("abc@asdf.ch");
		someUser.setFirstName("Franz");
		someUser.setLastName("Meier");
		someUser.setPassword("asdf");
		someUser.setEnableTutor(false);
		
		List<User> testUserList = new ArrayList<User>();
		testUserList.add(someUser);
		
		when(testUserDao.findOne(any(Long.class))).thenReturn(user);
		when(testUserDao.save(captor.capture())).thenReturn(null);
		when(testUserDao.findAll()).thenReturn(testUserList);
		
	}
	
	@Test
	public void testSaveUser() throws IOException {
		
		User testUser = testUserService.saveUser(testSignupForm);

		assertEquals("ese@hs15.ch", testUser.getEmail());
		assertEquals("John", testUser.getFirstName());
		assertEquals("Doe", testUser.getLastName());
		assertEquals("asdf", testUser.getPassword());
		assertEquals(testPic.getBytes(), testUser.getPic().getFile());
		
		assertEquals(user, captor.getValue());
	}
	
	@Test(expected=InvalidUserException.class)
	public void testSaveUserExisting() throws IOException {
		testSignupForm.setEmail("abc@asdf.ch");
		testUserService.saveUser(testSignupForm);
	}
	
	@Test
	public void testUpdateUser() throws InvalidUserException{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		
		User modifiedUser = testUserService.updateUser(testForm);
		assertEquals(ecpectedUser, modifiedUser);		
	}
	
	@Test
	public void testValidateModifyUserFormWCorrect(){
		assertTrue(testUserService.validateModifyUserForm(testForm));
	}
	
	@Test
	public void testUpdateUserEmptyFirstname() throws InvalidUserException{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		testForm.setFirstName("");
		User modifiedUser = testUserService.updateUser(testForm);
		assertEquals(user.getFirstName(), modifiedUser.getFirstName());	
		assertEquals(ecpectedUser.getLastName(), modifiedUser.getLastName());
		assertEquals(ecpectedUser.getPassword(), modifiedUser.getPassword());
	}
	
	@Test
	public void testUpdateUserEmptyLastname() throws InvalidUserException{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		testForm.setLastName("");
		User modifiedUser = testUserService.updateUser(testForm);
		assertEquals(user.getLastName(), modifiedUser.getLastName());	
		assertEquals(ecpectedUser.getFirstName(), modifiedUser.getFirstName());
		assertEquals(ecpectedUser.getPassword(), modifiedUser.getPassword());
	}
	
	@Test
	public void testUpdateUserEmptyPassword() throws InvalidUserException{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		testForm.setPassword("");
		User modifiedUser = testUserService.updateUser(testForm);
		assertEquals(user.getPassword(), modifiedUser.getPassword());	
		assertEquals(ecpectedUser.getFirstName(), modifiedUser.getFirstName());
		assertEquals(ecpectedUser.getLastName(), modifiedUser.getLastName());
	}
	
	@Test
	public void testUpdateUserUpdateCompetences() throws InvalidUserException{
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		testForm.setPassword("");
		User modifiedUser = testUserService.updateUser(testForm);
		for(Competence c : modifiedUser.getCompetences()){
			assertTrue(c.getisEnabled());
		}
	}
	
	@Test
	public void setHouerlyRateTest(){
		Mockito.when(testUserDao.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());
		User returnedUser = testUserService.setHouerlyRate(user, houerlyRate);
		assertTrue(houerlyRate == returnedUser.getHouerlyRate());
	}
	
	

}
