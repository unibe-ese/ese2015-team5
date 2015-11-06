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
	
	
	
//	@RequestMapping(value="/register", method=RequestMethod.GET)
//	public ModelAndView getRegisterPage(){
//		return null;
//	}
//	
//	@RequestMapping(value="/register", method=RequestMethod.POST)
//	public ModelAndView register(){
//		return null;
//	}
	
	
	
	 
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView getRegisterPage(){
    	ModelAndView model = new ModelAndView("register");
    	model.addObject("signupForm", new SignupForm());
    	return model;
    }
	
	
	
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;
    	System.out.println(result.getAllErrors().toString());
    	
    	if (!result.hasErrors() && !signupForm.getProfilePic().isEmpty()) {
            try {
            	
              	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("show");
            	
            } catch (InvalidUserException e) {           	
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	System.out.println("nope");
        	model = new ModelAndView("index");
        	model.addObject("signupForm", new SignupForm());
        }    
    	return model;
    }
	
	
}
