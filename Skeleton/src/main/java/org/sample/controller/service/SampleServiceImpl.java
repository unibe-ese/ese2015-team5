package org.sample.controller.service;


import org.sample.controller.exceptions.InvalidUserException;
<<<<<<< HEAD
=======
import org.sample.controller.pojos.ModifyUserForm;
>>>>>>> refs/remotes/origin/master
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.UserDao;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
>>>>>>> refs/remotes/origin/master
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }

<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master
        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
<<<<<<< HEAD
        if(signupForm.getTeamId() != 0){
        	 user.setTeamId(signupForm.getTeamId());
        }
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
    
//    public void saveFrom(createTeamForm createTeamForm) throws InvalidTeamException {
//		Team team = new Team();
//		team.setName(createTeamForm.getTeamName());
//		team.setCreationDateInMilisec(Calendar.getInstance().getTimeInMillis());
//		
//		Iterable<Team> teams = teamDao.findAll();
//		
//		for(Team t : teams){
//			if(t.equals(team)){
//				System.out.println("exception!");
//				throw new InvalidTeamException("This team already exists!");
//			}
//		}	
//		team = teamDao.save(team);		
//	}

//	public List<Team> getTeams() {
//		List<Team> teams = new ArrayList<Team>();
//		Iterable<Team> teamIt = teamDao.findAll();
//		for(Team t : teamIt){
//			teams.add(t);
//		}
//		return teams;
//		
//	}
=======
        user.setPassword(signupForm.getPassword());
        
        user = userDao.save(user);   // save object to DB
             
        signupForm.setId(user.getId());

        return signupForm;
    }
    
	public void updateFrom(ModifyUserForm form) {
		User user  = userDao.findOne(form.getId());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setPassword(form.getPassword());
		userDao.save(user);
	}
  
	public User loadUserByUserName(String name) {
		Iterable<User> users = userDao.findAll();
		for(User u : users){
			if(u.getEmail().equals(name)){
				return u;
			}
		}
		return null;
		
	}

	public User getCurrentUser() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		UsernamePasswordIDAuthenticationToken authtok;
		try{
			authtok = (UsernamePasswordIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		}catch(ClassCastException e){
			return null;
		}
		return userDao.findOne(authtok.getId());
		
	}
>>>>>>> refs/remotes/origin/master
}
