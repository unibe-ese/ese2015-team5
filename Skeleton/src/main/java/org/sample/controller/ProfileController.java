package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("user")
public class ProfileController {
	
	@Autowired
	SampleService sampleService;
	
	
    @RequestMapping( value = "/profile")
    public ModelAndView gotoProfile(){
    	ModelAndView model; 
    	User user = sampleService.getCurrentUser();
    	if(user != null){
    		model = new ModelAndView("profile");
    		model.addObject("user", user);
    		model.addObject("modifyUserForm", new ModifyUserForm());
    	}
    	else{
    		model = new ModelAndView("index");
    	}
    	return model;
    }
	
	
	@RequestMapping(value="/profile/modifyUser", method=RequestMethod.POST)
	public ModelAndView modifyUser( @ModelAttribute("user") User user, @Valid ModifyUserForm form, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(form.getPassword().equals(form.getPasswordControll())){
			form.setId(user.getId());
			sampleService.updateFrom(form);
	    	
		}
		
		ModelAndView model = new ModelAndView("profile");   
    	model.addObject("user", user);
		model.addObject("modifyUserForm", new ModifyUserForm());

        return model;
	}
	
}
