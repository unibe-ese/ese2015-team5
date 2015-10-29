package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView gotoProfile(Model model){
    	System.out.println("ENTERED PROFILE ---------------------");
    	System.out.println("contains?: " + model.containsAttribute("modifyUserForm"));
    	System.out.println("contains register?: " + model.containsAttribute("org.springframework.validation.BindingResult.register"));
    	System.out.println(model.asMap().keySet().toString());
    	System.out.println(model.asMap().toString());
    	
    	ModelAndView modelAndView = new ModelAndView("profile", model.asMap());
    	User user = sampleService.getCurrentUser();
    	modelAndView.addObject("user", user);
    	
    	if(user == null){
    		return new ModelAndView("index");
    	}
    	
    	else if(!model.containsAttribute("modifyUserForm") ){
    		System.out.println("contains?: " + model.containsAttribute("modifyUserForm"));
    		
    		ModifyUserForm modForm = new ModifyUserForm();
    		modForm.setEnableTutor(user.getEnableTutor());
    		modelAndView.addObject("modifyUserForm", modForm);
    		
    	}
    	
    	return modelAndView;
    }
    
    public ModelAndView prepareProfile(User user){
    	ModelAndView model = new ModelAndView("profile");
		model.addObject("user", user);
		ModifyUserForm modForm = new ModifyUserForm();
		modForm.setEnableTutor(user.getEnableTutor());
		model.addObject("modifyUserForm", modForm);
		return model;
    }
		
    
	@RequestMapping(value="/modifyUser", method=RequestMethod.POST)
	public String modifyUser( @ModelAttribute("user") User user, 
			 @Valid ModifyUserForm form, BindingResult result, RedirectAttributes redirectAttributes){
		form.setId(user.getId());
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("modifyUserForm", form);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modifyUserForm", result);
		
			return "redirect:profile";
		}
		else if(sampleService.validToUpdate(form)){	
			user = sampleService.updateFrom(form);
		}
        return "redirect:index";
	}
	
	@RequestMapping(value="/addCompetence", method=RequestMethod.POST)
	public ModelAndView addCompetence(@ModelAttribute("addCompetenceForm") @Valid AddCompetenceForm form, 
			@ModelAttribute("user") User user, BindingResult result){
		System.out.println("competence");
		ModelAndView model;

		if(result.hasErrors()){
			System.out.println("error");
			model = new ModelAndView("profile");
		}
		return null;
		
	}
	
}
