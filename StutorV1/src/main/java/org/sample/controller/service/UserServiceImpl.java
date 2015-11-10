package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Competence;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.ProfilePictureDao;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Provides functionalities like searching, modifying and saving of {@link User} in the DB.
 * 
 * @author ESE Team5
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Autowired
	CompetenceDao compDao;
	@Autowired
	ProfilePictureDao profilePicDao;
	
	public User getUserByEmail(String email) {
		for (User u:userDao.findAll())
		{
			if(u.getEmail().equals(email))
			return u;
		}
		return null;
	}
	
	public User getUserById(long userId) {
		return userDao.findOne(userId);
	}

	public User getCurrentUser() {
		UsernamePasswordIDAuthenticationToken authtok;
		try{
			authtok = (UsernamePasswordIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		}catch(ClassCastException e){
			return null;
		}
		return userDao.findOne(authtok.getId());
		
	}
	
	@Transactional
	public User saveUser(SignupForm sgnUp) throws InvalidUserException {
		
		MultipartFile file = sgnUp.getProfilePic();
        ProfilePicture profilePicture = new ProfilePicture();
        try {       	
        	profilePicture.setFile(file.getBytes());    	
        	saveProfilePicture(profilePicture);
        } catch (Exception e) {
            throw new InvalidUserException("Picture could not be processed");
        }
   
        User user = new User();
        user.setFirstName(sgnUp.getFirstName());
        user.setEmail(sgnUp.getEmail());
        user.setLastName(sgnUp.getLastName());
        user.setPassword(sgnUp.getPassword());
        user.setEnableTutor(false);
        user.setPic(profilePicture);
        user.setAboutYou(null);
        userDao.save(user);
        
        return user;
	}

	/**
	 * Only call this method after calling validateModifyUserForm.
	 * 
	 */
	public User updateUser(ModifyUserForm mod) throws InvalidUserException {
		User user  = userDao.findOne(mod.getId());
		if(user.getEnableTutor() != mod.getEnableTutor()){
			for(Competence c : user.getCompetences()){
				c.setisEnabled(mod.getEnableTutor());
				compDao.save(c);
			}
		}
		user.setFirstName(mod.getFirstName());
		user.setLastName(mod.getLastName());
		user.setPassword(mod.getPassword());
		user.setEnableTutor(mod.getEnableTutor());
		user.setAboutYou(mod.getAboutYou());
		return userDao.save(user);
	}

	public boolean validateModifyUserForm(ModifyUserForm mod) {
		User user = userDao.findOne(mod.getId());
    	if(user == null || !mod.getPassword().equals(mod.getPasswordControll())){
    		return false;
    	}
    	
    	return true;
	}

    public void saveProfilePicture(ProfilePicture profilePicture){
    	profilePicDao.save(profilePicture);
    }

	public void updateProfilePicture(ProfilePicture profilePicture) {
		System.out.println("updateProfile");
		User user = getCurrentUser();
		ProfilePicture pic = user.getPic();
		pic.setFile(profilePicture.getFile());
		userDao.save(user);
		profilePicDao.save(pic);		
	}
    



}
