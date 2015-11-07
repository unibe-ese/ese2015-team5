package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests that originate from the Registration page, or want to redirect to it. 
 * 
 * @author ESE Team5
 *
 */

@Controller
public class RegistrationController {
	
	
	@Autowired
	SampleService sampleService;
	@Autowired
	UserService userService;
	

	/*
	 *	Here we'd like to create the controller logic for the registration process
	 *
	 *	It is capable of:
	 *	
	 *	+Handling the register page get request
	 *	+Handling the registration form submission
	 *	
	 *	+
	 *	+
	 *
	 * 	
	 */
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getRegisterPage(){
		ModelAndView view = new ModelAndView("register");
		view.addObject("signupForm", new SignupForm());
		return view;
	}
	
	/**
	 * Validates a {@link SignupForm} creates a {@link User} and saves it to DB.
	 * 
	 *  Receives a {@link SignupForm} and checks, if the user input is valid. These possible errors are in 
	 *  the {@link BindingResult}. If there are errors, returns a {@link ModelAndView} of the registration page.
	 *  If there are no errors ({@link SignupForm} valid, and ProfilePicture not empty), the {@link SignupForm}
	 *  is passed to the {@link UserService} where the User and ProfilePicture are linked and saved to the 
	 *  DB. 
	 * 
	 * @param signupForm: A {@link SignupForm} with fields to create a new User
	 * @param result: Information about the validations of the {@link SignupForm} (done with Annotations)
	 * @param att
	 * @return: A {@link ModelAndView} of the correct page.
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes att){
		ModelAndView view;
		
		if (!result.hasErrors() && !signupForm.getProfilePic().isEmpty()){
			try {
				
				sampleService.saveFrom(signupForm);
				view = new ModelAndView("show");
				
			} catch (InvalidUserException e){
				
				view = new ModelAndView("index");
				view.addObject("page_error", e.getMessage());
			} 
		} else {
			
			view = new ModelAndView("register");
			view.addObject("signupForm", new SignupForm());
			
		}
		return view;
	}
}
