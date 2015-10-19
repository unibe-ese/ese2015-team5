package org.sample.controller;


import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("signupForm", new SignupForm());
        return model;
    }
 

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;
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
    
    @RequestMapping(value="/profile", params={"userId"}, method=RequestMethod.GET)
    public ModelAndView profile(@RequestParam("userId") int userId){
    	ModelAndView model = new ModelAndView();
    	User user;
    	try{
    		user = sampleService.getUser(userId);
    	}catch(InvalidUserException e){
    		model.addObject("signupForm", new SignupForm());
    		return model;
    	}
    	model = new ModelAndView("profile");
    	model.addObject("user", user);
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}

