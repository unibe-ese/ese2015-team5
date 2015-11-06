package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegistrationController {
	
	
	@Autowired
	SampleService sampleService;
	

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
			
			view = new ModelAndView("index");
			view.addObject("signupForm", new SignupForm());
			
		}
		return view;
	}
}
