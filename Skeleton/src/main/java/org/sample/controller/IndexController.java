package org.sample.controller;


import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return model;
    }
    
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "access-denied";
    }
   
  
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have permission to do that!");
        return "redirect:/";
    }

}


