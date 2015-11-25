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
	
	public static User buildUser(SignupForm signupForm) throws InvalidUserException{	
		User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setPassword(signupForm.getPassword());
        user.setEnableTutor(false);
        user.setAboutYou(null);
        assert user != null;
		return user;
	}
	
	public static User modifyUser(ModifyUserForm modifyUserForm){
		
		return null;
	}

}
