package org.sample.controller.service;


import java.util.ArrayList;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
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
import org.springframework.web.multipart.MultipartFile;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired	  ProfilePictureDao profilePicDao;
    @Autowired	  CompetenceDao compDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{
    	System.out.println("saveForm");
        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }
        
        MultipartFile file = signupForm.getProfilePic();
        ProfilePicture profilePicture = new ProfilePicture();
        try {
        	
        	
        	profilePicture.setFile(file.getBytes());
        	
        	saveProfilePicture(profilePicture);
        	
           
        } catch (Exception e) {
            throw new InvalidUserException("Picture could not be processed");
        }
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setPassword(signupForm.getPassword());
        user.setEnableTutor(false);
        user.setPic(profilePicture);
        user.setAboutYou(null);
        user = userDao.save(user);  
        
     
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
		if(user.getEnableTutor() != form.getEnableTutor()){
			for(Competence c : user.getCompetences()){
				c.setisEnabled(form.getEnableTutor());
				compDao.save(c);
			}
		}
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setPassword(form.getPassword());
		user.setEnableTutor(form.getEnableTutor());
		user.setAboutYou(form.getAboutYou());
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
    

	public void updateProfilePicture(ProfilePicture profilePicture) {
		System.out.println("update");
		User user = getCurrentUser();
		ProfilePicture pic = user.getPic();
		pic.setFile(profilePicture.getFile());
		userDao.save(user);
		profilePicDao.save(pic);
		
	}
    
    public void saveProfilePicture(ProfilePicture profilePicture){
    	profilePicDao.save(profilePicture);
    }
    
    public ProfilePicture getProfilePicture(long userId){
    	User user = userDao.findOne(userId);
    	if(user != null){
    		return user.getPic();
    	}
    	return getCurrentUser().getPic();
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
		comp.setisEnabled(user.getEnableTutor());
		compDao.save(comp);
	}

	public Competence findCompetence(long compId) {
		return compDao.findOne(compId);	
	}
	
	public List<Competence> findCompetenceLike(String string){
		List<Competence> comps = new ArrayList<Competence>();
		for(Competence c : compDao.findAll()){
			if(c.getDescription().contains(string)){
				comps.add(c);
			}
		}
		return comps;
	}

}
