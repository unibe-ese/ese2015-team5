package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.RegistrationForm;
import org.sample.model.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	
	public User getCurrentUser();
	
	public int countUsers();
	
	public Iterable<User> getUsers();
	
	public User saveUser(RegistrationForm reg) throws InvalidUserException;
	
	public User updateUser(ModifyUserForm mod) throws InvalidUserException;
	
	public boolean validateModifyUserForm(ModifyUserForm mod);
		
	public boolean validToUpdate(ModifyUserForm form);

}
