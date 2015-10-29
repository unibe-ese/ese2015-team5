package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.pojos.AddCompetenceForm;
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
    		ModifyUserForm modForm = new ModifyUserForm();
    		modForm.setEnableTutor(user.getEnableTutor());
    		model.addObject("modifyUserForm", modForm);
    		model.addObject("addCompetenceForm", new AddCompetenceForm());

    	}
    	else{
    		model = new ModelAndView("index");
    	}
    	return model;
    }
		
    
	@RequestMapping(value="/modifyUser", method=RequestMethod.POST)
	public ModelAndView modifyUser( @ModelAttribute("user") User user, 
			 @Valid ModifyUserForm form, BindingResult result, RedirectAttributes redirectAttributes){
		form.setId(user.getId());
		ModelAndView model = new ModelAndView("profile");  
		if(result.hasErrors()){
			model.addObject("error", "Invalid Information");
			
		}
		else if(sampleService.validToUpdate(form)){	
			System.out.println("if");
			user = sampleService.updateFrom(form);
			model.addObject("user", user);
			ModifyUserForm modForm = new ModifyUserForm();
    		modForm.setEnableTutor(user.getEnableTutor());
    		model.addObject("modifyUserForm", modForm);
    		model.addObject("addCompetenceForm", new AddCompetenceForm());
		}
        return model;
	}
	
	@RequestMapping(value="profile/addCompetence", method=RequestMethod.POST)
	public ModelAndView addCompetence(){
		System.out.println("competence");
		return null;
	}
	
}
