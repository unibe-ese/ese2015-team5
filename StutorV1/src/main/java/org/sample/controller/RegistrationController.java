package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	UserService userService;

	/**
	 * Creates a {@link ModelAndView} for the registration page.<p>
	 * If the prevous model already contained a Object {@link SignupForm}, no new
	 * SignupForm is added. (When register redirects to this method.)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getRegisterPage(Model model){
		ModelAndView newModel;
		if(model.containsAttribute("signupForm")){
			newModel = new ModelAndView("register", model.asMap());
			return newModel;
		}		
		newModel = new ModelAndView("register");
		newModel.addObject("signupForm", new SignupForm());
		assert newModel != null;
		return newModel;
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
	public String register(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes att){
		
		if(result.hasErrors() || signupForm.getProfilePic().isEmpty()){
			att.addFlashAttribute("signupForm", new SignupForm());
			att.addFlashAttribute("org.springframework.validation.BindingResult.signupForm", result);

			if(signupForm.getProfilePic().isEmpty()){
				att.addFlashAttribute("pictureError", "Please choose a picture");
			}
			
			return "redirect:register";
		}	
		try {				
			userService.saveUser(signupForm);			
		} catch (InvalidUserException e){
			att.addFlashAttribute("page-error", e.getMessage());
			att.addFlashAttribute("signupForm", new SignupForm());
			return "redirect:register";
		} 
		
		return "redirect:login";
	}
}
