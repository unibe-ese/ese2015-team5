package org.sample.controller.service;

import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Competence;
import org.sample.model.ProfilePicture;
import org.sample.model.User;



public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

	public User loadUserByUserName(String name);

	public User getCurrentUser();
	
	public void saveProfilePicture(ProfilePicture profilePicture);

	public User updateFrom(ModifyUserForm form);
	
	public boolean validToUpdate(ModifyUserForm form);
	
	public List<Competence> getCompetences(long userId);

	public void removeCompetence(long compId);

	public void addCompetence(AddCompetenceForm form);

	public Competence findCompetence(long compId);
    
	public ProfilePicture getProfilePicture();

}
