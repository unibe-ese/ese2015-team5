package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.dao.ProfilePictureDao;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ProfilePictureDao profilePicDao;

	public User getCurrentUser() {
		
		UsernamePasswordIDAuthenticationToken authtok;
		try{
			authtok = (UsernamePasswordIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		}catch(ClassCastException e){
			return null;
		}
		return userDao.findOne(authtok.getId());
	}

	public long countUsers() {
		return userDao.count();
	}

	public Iterable<User> getUsers() {
		return userDao.findAll();
	}

	@Transactional
	public User saveUser(SignupForm signupForm) throws InvalidUserException {

		ProfilePicture pic = new ProfilePicture(signupForm.getProfilePic());
		profilePicDao.save(pic);
		
		User user = new User(signupForm, pic);
		userDao.save(user);
		
		return user;
	}

	public User updateUser(ModifyUserForm mod) throws InvalidUserException {
		User user = this.getCurrentUser();
		user.update(mod);
		return userDao.save(user);
	}
	
	public ProfilePicture updateProfilePicture(MultipartFile file){
		User user = this.getCurrentUser();
		ProfilePicture pic = user.getPic();
		pic.update(file);
		return profilePicDao.save(pic);
	}

	public boolean validateModifyUserForm(ModifyUserForm mod) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validToUpdate(ModifyUserForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserById(long id) {
		return userDao.findOne(id);
	}



}
