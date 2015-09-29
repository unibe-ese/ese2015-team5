package org.sample.controller.service;

import java.util.Calendar;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.createTeamForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired 	  TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        user.setTeam(signupForm.getTeam());
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }

	public void saveFrom(createTeamForm createTeamForm) throws InvalidTeamException {
		Team team = new Team();
		team.setName(createTeamForm.getTeamName());
		team.setCreationDateInMilisec(Calendar.getInstance().getTimeInMillis());
		
		Iterable<Team> teams = teamDao.findAll();
		
		for(Team t : teams){
			if(t.equals(team)){
				System.out.println("exception!");
				throw new InvalidTeamException("This team already exists!");
			}
		}	
		team = teamDao.save(team);		
	}

	public Iterable<Team> getTeams() {
		return teamDao.findAll();
		
	}
}