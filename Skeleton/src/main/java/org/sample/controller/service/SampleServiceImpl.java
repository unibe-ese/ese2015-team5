package org.sample.controller.service;


import java.util.ArrayList;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.Competence;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.ProfilePictureDao;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired	  ProfilePictureDao profilePicDao;
    @Autowired	  CompetenceDao compDao;
    
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
        user.setPassword(signupForm.getPassword());
        user.setEnableTutor(false);
        user = userDao.save(user);   // save object to DB
        
        System.out.println(this.countUsers());
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;
    }
    
    public boolean validToUpdate(ModifyUserForm form){
    	User user = userDao.findOne(form.getId());
    	if(user == null || !form.getPassword().equals(form.getPasswordControll()) || form.getLastName().equals("")
    			||  form.getFirstName().equals("")){
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Only call this after validToUpdate
     */
    
	public User updateFrom(ModifyUserForm form) {
		User user  = userDao.findOne(form.getId());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setPassword(form.getPassword());
		user.setEnableTutor(form.getEnableTutor());
		return userDao.save(user);
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
    
    
    public long countUsers(){
    	long count = userDao.count();
    	return count;
    }
    
    
    public void saveProfilePicture(ProfilePicture profilePicture){
    	profilePicDao.save(profilePicture);
    }
    
    public ProfilePicture getProfilePicture(){
    	Iterable<ProfilePicture> pics = profilePicDao.findAll();
    	for (ProfilePicture p : pics){
    		return p;
    	}
		return null;
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
	
	public List<Competence> getCompetences(long userId){
		
		List<Competence> competences = new ArrayList<Competence>();
		for(Competence comp : compDao.findAll()){
			if(comp.getOwner().getId() == userId){
				competences.add(comp);
			}
		}
		return competences;
		
	}

	public void removeCompetence(long compId) {
//		System.out.println("removeComp");
//		System.out.println(compId);
//		Competence comp = compDao.findOne(compId);
//		User owner = comp.getOwner();
//		comp.setOwner(null);
//		List<Competence> competences = owner.getCompetences();
//		competences.remove(comp);
//		System.out.println(competences.contains(comp));
//		owner.setCompetences(competences);
//		compDao.delete(compId);
		Competence comp = compDao.findOne(compId);
		comp.setOwner(null);
		compDao.delete(compId);
	}

	public void addCompetence(AddCompetenceForm form) {
		Competence comp = new Competence();
		User user = userDao.findOne(form.getOwnerId());
		comp.setDescription(form.getDescription());
		comp.setOwner(user);
		compDao.save(comp);
	}

	public Competence findCompetence(long compId) {
		return compDao.findOne(compId);
		
	}
}
