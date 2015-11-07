package org.sample.controller.builder;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.User;

public class UserBuilder {
	
	public UserBuilder(SignupForm signupForm){
		
	}
	
	public UserBuilder(ModifyUserForm modifyUserForm){
		
	}
	
	public User buildUser(SignupForm signupForm) throws InvalidUserException{

		return null;
	}

}
