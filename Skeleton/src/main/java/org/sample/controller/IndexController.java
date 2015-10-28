package org.sample.controller;


import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> refs/remotes/origin/master
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

<<<<<<< HEAD
    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("signupForm", new SignupForm());
        return model;
    }
    
//    @RequestMapping( value = "/newTeam")
//    public ModelAndView goToTeam(){
//    	ModelAndView model; 
//      	model = new ModelAndView("newTeam");	
//      	model.addObject("teamForm", new createTeamForm());
//    	return model;
//    }
=======
	
    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	System.out.println("index");
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("signupForm", new SignupForm());
    	System.out.println("index");
        return model;
    }
    
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied() {
    	System.out.println("access denided");
        return "access-denied";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView getRegisterPage(){
    	ModelAndView model = new ModelAndView("register");
    	model.addObject("signupForm", new SignupForm());
    	return model;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error", required=false) boolean error, 
      ModelMap model) {
    System.out.println("getLoginPage");
     if (error == true) {

      model.put("error", "You have entered an invalid username or password!");
     } else {
      model.put("error", "");
     }
      

     return "login";
    }
    

>>>>>>> refs/remotes/origin/master

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;
<<<<<<< HEAD
=======
    	System.out.println("create");
>>>>>>> refs/remotes/origin/master
    	if (!result.hasErrors()) {
            try {
              	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("show");
            } catch (InvalidUserException e) {           	
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {        	
        	model = new ModelAndView("index");
        	model.addObject("signupForm", new SignupForm());
        }    
    	return model;
    }
    
<<<<<<< HEAD

//	@RequestMapping(value="/createTeam", method=RequestMethod.POST)
//    public ModelAndView createTeam(@ModelAttribute("teamForm") createTeamForm createTeamForm){
//    	ModelAndView model;
//    	try {
//        	sampleService.saveFrom(createTeamForm);
//        	model = new ModelAndView("show");
//        } catch (InvalidTeamException e) {
//        	model = new ModelAndView("index");
//        	model.addObject("page_error", e.getMessage());
//        }
//   
//    	model = new ModelAndView("index");
//    	model.addObject("signupForm", new SignupForm());    	
//        return model;
//    	
//    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
=======
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
    	System.out.println("securityError");
>>>>>>> refs/remotes/origin/master
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}


