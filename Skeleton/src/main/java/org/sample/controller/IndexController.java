package org.sample.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.createTeamForm;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    	model.addObject("teams", loadTeams());
        return model;
    }
    
    @RequestMapping( value = "/newTeam")
    public ModelAndView goToTeam(){
    	ModelAndView model; 
      	model = new ModelAndView("newTeam");	
      	model.addObject("teamForm", new createTeamForm());
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
        }    
    	return model;
    }
    
    private List<Team> loadTeams() {
		List<Team> teams = new ArrayList<Team>();
		Iterable<Team> teamIt = sampleService.getTeams();
		for(Team t : teamIt){
			teams.add(t);
		}
		return teams;
	}

	@RequestMapping(value="/createTeam", method=RequestMethod.POST)
    public ModelAndView createTeam(@ModelAttribute("teamForm") createTeamForm createTeamForm){
    	ModelAndView model;
    	try {
        	sampleService.saveFrom(createTeamForm);
        	model = new ModelAndView("show");
        } catch (InvalidTeamException e) {
        	model = new ModelAndView("index");
        	model.addObject("page_error", e.getMessage());
        }
   
    	model = new ModelAndView("index");
    	model.addObject("signupForm", new SignupForm());    	
        return model;
    	
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}


