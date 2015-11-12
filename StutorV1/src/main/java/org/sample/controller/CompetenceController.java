package org.sample.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sample.controller.pojos.EditCalendarForm;
import org.sample.controller.pojos.EditCompetenceForm;
import org.sample.controller.service.CompetenceService;
import org.sample.model.Competence;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CompetenceController {

	@Autowired 
	CompetenceService compService;
	
	/**
	 * Deletes a competence
	 * 
	 * Uses the CompetenceService to delete a competence. If there is no competence with the correct ID, 
	 * the method does nothing.
	 * 
	 * @param compId The id of the competence.
	 * @return Redirects to the profile page.
	 */
	@RequestMapping(value="/profile/deleteComp/{compId}", method=RequestMethod.GET)
	public String deleteCompetence(@PathVariable("compId")long compId){
		Competence comp = compService.findCompetenceById(compId);
		if(comp != null){
			compService.deleteCompetence(comp);
		}
		return "redirect:/profile";
	}
	
	@RequestMapping(value="/profile/editComp/{compId}", method=RequestMethod.GET)
	public ModelAndView editCompetence(@PathVariable("compId")Long compId, HttpSession session, Model model){
		
		User user  = (User)session.getAttribute("user");
	
		Competence comp = compService.findCompetenceById(compId);

		ModelAndView newModel = new ModelAndView("editCompetence", model.asMap());
		
		if(!user.getCompetences().contains(comp)){
			return new ModelAndView("index");
		}
		newModel.addObject("competence", comp);
		if(!model.containsAttribute("editCompetenceForm") ){
			EditCompetenceForm editForm = new EditCompetenceForm(comp);
			
			newModel.addObject("editCompetenceForm", editForm);
		}
		newModel.addObject("editCalendarForm", new EditCalendarForm());
		return newModel;
	}
	
	@RequestMapping(value="/profile/editComp/{compId}", method=RequestMethod.POST)
	public String editCompetence(@ModelAttribute("editCompetenceForm") @Valid EditCompetenceForm editForm, BindingResult result, RedirectAttributes redirectedAttribtues,
			@PathVariable("compId") long compId){
		editForm.setCompReferenceId(compId);
		System.out.println(result.toString());
		if(result.hasErrors()){
			System.out.println("error");
			redirectedAttribtues.addFlashAttribute("editCompetenceForm", editForm);
			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.editCompetenceForm", result);
			
			return "redirect:/profile/editComp/"  + compId;
		}
		
		compService.updateCompetence(editForm);
		for( int i = 0; i < editForm.getAvailabilityBoard().length; i++){
			for(int j = 0; j < editForm.getAvailabilityBoard()[i].length; j++){
				System.out.println(editForm.getAvailabilityBoard()[i][j]);
			}
		}
		System.out.println(editForm.getAvailabilityBoard().toString());
		return "redirect:/profile/editComp/"  + compId;
	}
    
    

}


