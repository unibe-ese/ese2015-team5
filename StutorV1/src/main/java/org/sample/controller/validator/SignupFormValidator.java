package org.sample.controller.validator;

import org.sample.controller.pojos.SignupForm;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignupFormValidator implements Validator{
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object signupForm, Errors error) {
		SignupForm form = (SignupForm) signupForm;
		Iterable<User> users = userDao.findAll();
		
		String email = form.getEmail();
		
//		
//		for (User u : users){
//			if (u.getEmail().equals(email)){
//				error.rejectValue(email, "This Email address already exists");
//			}
//		}
	}

}
