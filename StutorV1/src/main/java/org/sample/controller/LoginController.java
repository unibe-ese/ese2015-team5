package org.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests that have to do with logging in. 
 */

@Controller
public class LoginController {

	
	/**
	 * This method handles the GET request for the login page.
	 * It should return a valid login page.
	 * a login page contains a form with:
	 * 	
	 * 	action = ./j_spring_security_check
	 * 	method = post
	 * 	an input field with name attribute = j_username
	 *  an input field with name attribute = j_password
	 *  an input field for submission
	 * 
	 * if the login page is not valid throw an error (very difficult to implement)
	 * if no error is thrown the login mechanism won't work anyway
	 * 
	 * @return ModelAndView loginPageView
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(value="error", required=false) boolean error, ModelMap model){
		if (error){
			model.put("error", "You have entered an invalid email or password");
		} else {
			model.put("error", null);
		}
		
		ModelAndView loginPageView = new ModelAndView("login");
		
		assert loginPageView != null;
		return loginPageView;
	}
}
