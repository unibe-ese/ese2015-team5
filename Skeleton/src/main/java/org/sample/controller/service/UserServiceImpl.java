package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.RegistrationForm;
import org.sample.model.User;

public class UserServiceImpl implements UserService{

	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
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
