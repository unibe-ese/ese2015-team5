package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	
	public User getCurrentUser();
	
	public long countUsers();
	
	public Iterable<User> getUsers();
	
	public User saveUser(SignupForm signupForm) throws InvalidUserException;
	
	public User updateUser(ModifyUserForm mod) throws InvalidUserException;
	
	public ProfilePicture updateProfilePicture(MultipartFile file);
	
	public boolean validateModifyUserForm(ModifyUserForm mod);
		
	public boolean validToUpdate(ModifyUserForm form);

	public User getUserById(long userId);

}
