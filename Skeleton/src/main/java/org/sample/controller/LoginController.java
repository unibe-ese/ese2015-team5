package org.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


@Controller
public class LoginController {

	
	/*
	 *	Here we'd like to create the controller logic for the login process
	 *
	 *	It is capable of:
	 *	
	 *	+Handling the login page get request
	 *	+Handling multiple login failure
	 *	
	 *	+
	 *	+
	 *
	 * 	
	 */
	
	
	
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
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView getLoginPage(){
//		return null;
//	}
	
	
	/**
	 * Helper method!
	 * @param ModelAndView loginPageView
	 * @return ModelAndView loginPageView
	 */
//	public View checkLoginPageValidity(View loginPageView){
//		return loginPageView;
//		
//	}
	
	
//	
//	  
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String getLoginPage(@RequestParam(value="error", required=false) boolean error, 
//      ModelMap model) {
//    System.out.println("getLoginPage");
//     if (error == true) {
//
//      model.put("error", "You have entered an invalid username or password!");
//     } else {
//      model.put("error", "");
//     }
//      
//
//     return "login";
//    }
}
