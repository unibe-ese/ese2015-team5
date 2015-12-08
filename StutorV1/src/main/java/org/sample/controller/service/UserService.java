package org.sample.controller.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.NewsFeedArticleInterface;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.ProfilePicture;
import org.sample.model.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	
	public User getCurrentUser();
	
	public User saveUser(SignupForm sgnUp) throws InvalidUserException;
	
	public User updateUser(ModifyUserForm mod) throws InvalidUserException, UnsupportedEncodingException;
	
	public boolean validateModifyUserForm(ModifyUserForm mod);

	public User getUserById(long userId);
	
    public void saveProfilePicture(ProfilePicture profilePicture);
    
    public void updateProfilePicture(ProfilePicture profilePicture);

	public User setHouerlyRate(User user, float houerlyRate);

	public List<NewsFeedArticleInterface> buildNewsFeed();

}
