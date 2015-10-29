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
    	
    	ModelAndView modelAndView = new ModelAndView("profile", model.asMap());
    	User user = sampleService.getCurrentUser();
    	modelAndView.addObject("user", user);
    	
    	if(user == null){
    		return new ModelAndView("index");
    	}
    	
    	else if(!model.containsAttribute("modifyUserForm") ){
    	
    		ModifyUserForm modForm = new ModifyUserForm();
    		modForm.setEnableTutor(user.getEnableTutor());
    		modelAndView.addObject("modifyUserForm", modForm);
    		
    	}
    	System.out.println(user.getCompetences().toString());
    	model.addAttribute("competenceList", sampleService.getCompetences(user.getId()));
    	return modelAndView;
    }	
    
    /**
     * Checks if modified information is valid, then redirects to correct URL
     * 
     * If the new information is not valid, the errors are store in redirectedAttributes, which can be
     * accessed from the model in the gotoProfile-method. If the information is valid, they are saved to 
     * the database. 
     * 
     * @param user The logged in user	
     * @param form The form with the new information
     * @param result Possible errors in the form
     * @param redirectAttributes 
     * @return Returns the new URL 
     */
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
        return "redirect:profile";
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
