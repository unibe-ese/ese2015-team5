package org.sample.controller.service;

import java.util.List;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.createTeamForm;
import org.sample.model.Team;
import org.sample.model.TeamInterface;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
    
    
    public void saveFrom(createTeamForm createTeamForm) throws InvalidTeamException;


	public List<Team> getTeams();

}
