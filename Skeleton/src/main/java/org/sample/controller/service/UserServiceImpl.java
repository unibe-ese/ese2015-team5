package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
<<<<<<< Updated upstream
import org.sample.model.dao.ProfilePictureDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ProfilePictureDao profilePicDao;

	@Transactional
	public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException {
		
		ProfilePicture pic = new ProfilePicture(signupForm.getProfilePic());
		profilePicDao.save(pic);
		
		User user = new User(signupForm, pic);
		userDao.save(user);

		signupForm.setId(user.getId());

		return signupForm;
	}
=======
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
>>>>>>> Stashed changes

	@Autowired
	UserDao userDao;
	
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User getUserById(long userId) {
		return userDao.findOne(userId);
	}

	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public int countUsers() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterable<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveUser(SignupForm signupForm) throws InvalidUserException {

		ProfilePicture pic = new ProfilePicture(signupForm.getProfilePic());
		profilePicDao.save(pic);
		
		User user = new User(signupForm, pic);
		userDao.save(user);
		
		return user;
	}

	public User updateUser(ModifyUserForm mod) throws InvalidUserException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateModifyUserForm(ModifyUserForm mod) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validToUpdate(ModifyUserForm form) {
		// TODO Auto-generated method stub
		return false;
	}



}
