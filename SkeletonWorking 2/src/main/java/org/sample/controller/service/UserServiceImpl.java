package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.RegistrationForm;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides functionalities like searching, modifying and saving of {@link User} in the DB.
 * 
 * @author ESE Team5
 *
 */

@Service
public class UserServiceImpl implements UserService{

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

	public User saveUser(RegistrationForm reg) throws InvalidUserException {
		// TODO Auto-generated method stub
		return null;
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
