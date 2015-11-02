package org.sample.controller;


import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

	
    @Autowired
    SampleService sampleService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
    	System.out.println("index");
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("signupForm", new SignupForm());
    	System.out.println("index");
        return model;
    }
    
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied() {
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
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, @RequestParam("file") MultipartFile file, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;
    	System.out.println("create");
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
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have permission to do that!");
        return "redirect:/";
    }

}


