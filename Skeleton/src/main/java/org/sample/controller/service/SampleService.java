package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.ProfilePicture;
import org.sample.model.User;



public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

	public User loadUserByUserName(String name);

	public User getCurrentUser();
	
	public void saveProfilePicture(ProfilePicture profilePicture);
    

}
