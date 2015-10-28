package org.sample.controller.service;

<<<<<<< HEAD
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
=======
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.User;
>>>>>>> refs/remotes/origin/master



public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
<<<<<<< HEAD
=======

	public User loadUserByUserName(String name);

	public User getCurrentUser();

	public void updateFrom(ModifyUserForm form);
>>>>>>> refs/remotes/origin/master
    

}
