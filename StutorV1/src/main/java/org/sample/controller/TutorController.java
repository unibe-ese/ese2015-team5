package org.sample.controller;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.pojos.EditCompetenceForm;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.model.Competence;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.Week;
import org.sample.model.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
public class TutorController {

	@Autowired 
	CompetenceService compService;
	@Autowired
	CourseService courseService;
	
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
		
		if(!user.getCompetences().contains(comp) || comp == null){
			return new ModelAndView("index");
		}
		newModel.addObject("competence", comp);
		if(!model.containsAttribute("editCompetenceForm") ){
			EditCompetenceForm editForm = new EditCompetenceForm(comp);
			
			newModel.addObject("editCompetenceForm", editForm);
		}
		assert newModel != null;
		return newModel;
	}
	
	@RequestMapping(value="/profile/editComp/{compId}", method=RequestMethod.POST)
	public String editCompetence(@ModelAttribute("editCompetenceForm") @Valid EditCompetenceForm editForm, BindingResult result, RedirectAttributes redirectedAttribtues,
			@PathVariable("compId") long compId){
		editForm.setCompReferenceId(compId);
		if(result.hasErrors()){
			redirectedAttribtues.addFlashAttribute("editCompetenceForm", editForm);
			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.editCompetenceForm", result);
			
			return "redirect:/profile/editComp/"  + compId;
		}
		
		compService.updateCompetence(editForm);
		
		return "redirect:/profile/editComp/"  + compId;
	}
    
	/**
	 * Adds competences to a user and redirects to next URL
	 * 
	 * Checks if the addCompetenceForm has errors. If yes, the errors are added to the 
	 * redirectedAttributes, and the methods redirects to the profile page, to display errors.
	 * If there are no errors, the {@link org.sample.controller.service.CompetenceService} is used to add and save the Competence.
	 * 
	 * @param form: A pojo containing the edited user information. Validated by annotations.
	 * @param user: The user editing his profile.
	 * @param result: The result of validation. 
	 * @param redirectedAttribtues
	 * @return
	 */
	@RequestMapping(value="/addCompetence", method=RequestMethod.POST)
	public String addCompetence(@ModelAttribute("addCompetenceForm") @Valid AddCompetenceForm form, BindingResult result, RedirectAttributes redirectedAttribtues, HttpSession session){
		User user = (User)session.getAttribute("user");
		System.out.println("added error");
		if(result.hasErrors()){
			
			redirectedAttribtues.addFlashAttribute("addCompetenceForm", form);
			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.addCompetenceForm", result);
			
			return "redirect:profile";
		}
		form.setOwnerId(user.getId());
		compService.saveCompetence(form);
		return "redirect:profile";
		
	}

	@RequestMapping(value="/addCourse", method=RequestMethod.POST)
    public String addCourse(@ModelAttribute("addCourseForm") AddCourseForm form, HttpSession session, RedirectAttributes redirectAttributes){
		Date date;
		System.out.println("Unparsed: " + form.getDateString());
		System.out.println("Slot: " + form.getSlot());
		try {
			date = WeekDay.FORMAT.parse(form.getDateString());
			System.out.println("ParsedDate: " + date);
		} catch (ParseException e) {
			System.out.println("nope");
			e.printStackTrace();
			return "redirect:/profile";
		}
		
		User user = (User)session.getAttribute("user");
		form.setOwner(user);
		form.setDate(date);
		Course course;
		try {
			course = courseService.save(form);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/profile";
		}
		redirectAttributes.addFlashAttribute("week", courseService.buildCalendar(course.getDate()));
    	return "redirect:/profile";
    }
	
	@RequestMapping(value="/profile/nextWeek/{dateString}/", method=RequestMethod.GET)
	public String nextWeek(@PathVariable("dateString") String dateString, RedirectAttributes redirectAttributes){
		Date date;
		System.out.println(dateString);
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/profile";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Week week = courseService.buildCalendar(cal);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/profile";
	}
	
	@RequestMapping(value="/profile/lastWeek/{dateString}/", method=RequestMethod.GET)
	public String lastWeek(@PathVariable("dateString") String dateString, RedirectAttributes redirectAttributes){
		Date date;
		System.out.println(dateString);
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/profile";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Week week = courseService.buildCalendar(cal);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/profile";
	}

}


