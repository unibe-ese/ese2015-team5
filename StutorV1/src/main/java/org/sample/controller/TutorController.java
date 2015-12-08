package org.sample.controller;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidCourseDateException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.service.AddCompetenceFormValidator;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.UserService;
import org.sample.model.Competence;
import org.sample.model.User;
import org.sample.model.Week;
import org.sample.model.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles all the requests that have to do with:
 * <p>-Adding/deleting/editing {@link Competence}.
 * <p>-Adding/deleting {@link org.sample.model.Course Course}
 * <p>-Displaying next/last {@link Week} 
 * <p>-Setting houerlyRates/Grades for {@link Competence}
 * 
 * @author hess
 *
 */

@Controller
public class TutorController {

	@Autowired 
	CompetenceService compService;
	@Autowired
	CourseService courseService;
	@Autowired
	UserService userService;
	
	@Autowired
	public TutorController(CompetenceService compServ, CourseService cServ, UserService uServ){
		this.compService = compServ;
		this.courseService = cServ;
		this.userService = uServ;
	}
	
	/**
	 * Deletes a competence
	 * 
	 * Uses the CompetenceService to delete a competence. If there is no competence with the correct ID, 
	 * the method does nothing.
	 * 
	 * @param compId The id of the competence.
	 * @return Redirects to the profile page.
	 */
	@RequestMapping(value="/tutorProfile/deleteComp/{compId}", method=RequestMethod.GET)
	public String deleteCompetence(@PathVariable("compId")long compId){
		Competence comp = compService.findCompetenceById(compId);
		if(comp != null){
			compService.deleteCompetence(comp);
		}
		return "redirect:/tutorProfile?tab=tab2";
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
		AddCompetenceFormValidator validator = new AddCompetenceFormValidator();
		validator.validate(form, result);
		if(result.hasErrors()){
			System.out.println("errors");
			redirectedAttribtues.addFlashAttribute("addCompetenceForm", form);
			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.addCompetenceForm", result);
			
			return "redirect:tutorProfile?tab=tab2";
		}
		form.setOwnerId(user.getId());
		compService.saveCompetence(form);
		return "redirect:tutorProfile?tab=tab2";
		
	}

	/**
	 * Validates a {@link AddCourseForm} and then executes the correct operations.
	 * <p> Parses the dateString from the AddCourseForm. If the String cannot be parsed, redirects to profile.
	 * <p> If the Course already exists 
	 * ({@link org.sample.controller.service.CourseServiceImpl#alreadyExists(AddCourseForm form) alreadyExists(AddCourseForm form)})
	 * then the Course is deleted. (When you clicked on a Course that already existed).
	 * <p>Then the course is saved. A new {@link Week} is then created,
	 * ({@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)})
	 * from the date of the created Course, and added to the redirect Attributes.
	 * This way, the redirected page will contain display the calendar in the same week, as when 
	 * the request was sent. 
	 * 
	 * @param form: A {@link AddCourseForm} 
	 * @param session: The current session(contains the {@link User) that is logged in.
	 * @param redirectAttributes
	 * @return to profile.
	 */
	@RequestMapping(value="/addCourse", method=RequestMethod.POST)
    public String addCourse(@ModelAttribute("addCourseForm") AddCourseForm form, HttpSession session, RedirectAttributes redirectAttributes){
		Date date;
		try {
			date = WeekDay.FORMAT.parse(form.getDateString());
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/tutorProfile?tab=tab2";
		}
		User user = (User)session.getAttribute("user");
		form.setOwner(user);
		form.setDate(date);
		
		if(courseService.alreadyExists(form)){
			courseService.deleteCourse(form);
			redirectAttributes.addFlashAttribute("addCourseSuccess", "Deleted Course");
		}
		else{	
			try {
				courseService.save(form);
				redirectAttributes.addFlashAttribute("week", courseService.buildCalendar(date));
				redirectAttributes.addFlashAttribute("addCourseSuccess", "Created Course");
			} catch (ParseException | InvalidCourseDateException e) 
				{e.printStackTrace();
				redirectAttributes.addFlashAttribute("addCourseError", e.getMessage());
			}	
		}
    	return "redirect:/tutorProfile?tab=tab2";
    }
	
	/**
	 * Creates a model to represent the nextWeek of {@link User}'s calendar, based on a DateString that is passed.
	 * Tries to parse the dateString from the URl. 
	 * <p>Accepts dates of form dd.MM.yyyy </p>
	 * If not parsable, redirects to index. If parsable, adds 7 days, creates a new {@link Week} with
	 * {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
	 *  and redirects to profile.
	 * 
	 * @param dateString: A string representation of a Date.(Format: "dd.MM.yyyy") 
	 * @param session: The current session.
	 * @return: to the profile page.
	 */
	@RequestMapping(value="/tutorProfile/nextWeek/{dateString}/", method=RequestMethod.GET)
	public String nextWeek(@PathVariable("dateString") String dateString, RedirectAttributes redirectAttributes,
			HttpSession session){
		Date date;
		User user = (User)session.getAttribute("user");
		if(user == null){
			return "redirect:/index";
		}
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/tutorProfile?tab=tab2";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Week week = courseService.buildCalendar(cal, user);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/tutorProfile?tab=tab2";
	}
	
	/**
	 * Creates a model to represent the last week of {@link User}'s calendar, based on a DateString that is passed.
	 * Tries to parse the dateString from the URl. 
	 * <p>Accepts dates of form dd.MM.yyyy </p>
	 * If not parsable, redirects to index. If parsable, subtracts 1 day, creates a new {@link Week} with
	 * {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
	 *  and redirects to profile.
	 * 
	 * @param dateString: A string representation of a Date.(Format: "dd.MM.yyyy") 
	 * @param session: The current session.
	 * @return: to the profile page.
	 */
	@RequestMapping(value="/tutorProfile/lastWeek/{dateString}/", method=RequestMethod.GET)
	public String lastWeek(@PathVariable("dateString") String dateString, RedirectAttributes redirectAttributes,
			HttpSession session){
		
		Date date;
		User user = (User)session.getAttribute("user");
		if(user == null){
			return "redirect:/index";
		}
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/tutorProfile?tab=tab2";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Week week = courseService.buildCalendar(cal, user);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/tutorProfile?tab=tab2";
	}
	
	/**
	 * Parses and sets houerly Rate for a {@link User}.
	 * 
	 * The received String is parsed into a float. If there is an exception, an error message is added to the model
	 * and redirected back to the profile page.
	 * If the float is negative, adds error and redirects.
	 * If positive, saves it to {@link User}.
	 * 
	 * @param houerlyRateString: long in String format.
	 * @param session: Current session.
	 * @return to the profile.
	 */
	@RequestMapping(value="/tutorProfile/houerlyRate", method=RequestMethod.POST)
	public String setHouerlyRate(@RequestParam("houerlyRate") String houerlyRateString, HttpSession session,
			RedirectAttributes redirAttributes){
		User user = (User) session.getAttribute("user");

		float houerlyRate;
		try{
			houerlyRate = Float.parseFloat(houerlyRateString);
		}
		catch(NumberFormatException e){
			redirAttributes.addFlashAttribute("houerlyError", "You can only get paied in money");
			return "redirect:/tutorProfile?tab=tab2";
		}
		if(houerlyRate < 0){
			redirAttributes.addFlashAttribute("houerlyError", "Houerly rate cannot be below zero");
		}
		else{
			userService.setHouerlyRate(user, houerlyRate);
		}
		return "redirect:/tutorProfile?tab=tab2";
	}
	
}


