package org.sample.controller;


import javax.servlet.http.HttpServletRequest;

import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

	
    @Autowired
    SampleService sampleService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("competences", sampleService.findCompetenceLike(""));
        return model;
    }
    
    public ModelAndView index(Model model) {
    	System.out.println("index");
    	ModelAndView newModel = new ModelAndView("index", model.asMap());   
    	if(!model.containsAttribute("competences")){
    		newModel.addObject("competences", sampleService.findCompetenceLike(""));
    	}
    	
        return newModel;
    }
    
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "access-denied";
    }
    
//    @RequestMapping(value="/register", method=RequestMethod.GET)
//    public ModelAndView getRegisterPage(){
//    	ModelAndView model = new ModelAndView("register");
//    	model.addObject("signupForm", new SignupForm());
//    	return model;
//    }
    
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
    

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
//    	ModelAndView model;
//    	System.out.println(result.getAllErrors().toString());
//    	
//    	if (!result.hasErrors() && !signupForm.getProfilePic().isEmpty()) {
//            try {
//            	
//              	sampleService.saveFrom(signupForm);
//            	model = new ModelAndView("show");
//            	
//            } catch (InvalidUserException e) {           	
//            	model = new ModelAndView("index");
//            	model.addObject("page_error", e.getMessage());
//            }
//        } else {
//        	System.out.println("nope");
//        	model = new ModelAndView("index");
//        }    
//    	return model;
//    }
//    

    @RequestMapping(value="/findCompetenceLike", method=RequestMethod.GET)
    public ModelAndView findCompetenceLike(HttpServletRequest request){
    	System.out.println("findComp");
    	System.out.println(request.getParameter("searchQuery"));
    	String searchQuery = request.getParameter("searchQuery");
    	System.out.println(sampleService.findCompetenceLike(searchQuery));
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("competences", sampleService.findCompetenceLike(searchQuery));
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have permission to do that!");
        return "redirect:/";
    }
    
    

}


