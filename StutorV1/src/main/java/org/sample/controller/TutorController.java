package org.sample.controller;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	
//	/**
//	 * @Deprecated Is not used right now.
//	 * Gets the model for the editCompetence page.
//	 * 
//	 * 
//	 * @param compId
//	 * @param session
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value="/profile/editComp/{compId}", method=RequestMethod.GET)
//	public ModelAndView editCompetence(@PathVariable("compId")Long compId, HttpSession session, Model model){
//		
//		User user  = (User)session.getAttribute("user");
//	
//		Competence comp = compService.findCompetenceById(compId);
//
//		ModelAndView newModel = new ModelAndView("editCompetence", model.asMap());
//		
//		if(!user.getCompetences().contains(comp) || comp == null){
//			return new ModelAndView("index");
//		}
//		newModel.addObject("competence", comp);
//		if(!model.containsAttribute("editCompetenceForm") ){
//			EditCompetenceForm editForm = new EditCompetenceForm(comp);
//			
//			newModel.addObject("editCompetenceForm", editForm);
//		}
//		assert newModel != null;
//		return newModel;
//	}
//	

//	/**
//	 * Handles the POST request to modify a Competence
//	 * 
//	 * @param editForm
//	 * @param result
//	 * @param redirectedAttribtues
//	 * @param compId
//	 * @return
//	 */
//	@RequestMapping(value="/profile/editComp/{compId}", method=RequestMethod.POST)
//	public String editCompetence(@ModelAttribute("editCompetenceForm") @Valid EditCompetenceForm editForm, BindingResult result, RedirectAttributes redirectedAttribtues,
//			@PathVariable("compId") long compId){
//		editForm.setCompReferenceId(compId);
//		if(result.hasErrors()){
//			redirectedAttribtues.addFlashAttribute("editCompetenceForm", editForm);
//			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.editCompetenceForm", result);
//			
//			return "redirect:/profile/editComp/"  + compId;
//		}
//		
//		compService.updateCompetence(editForm);
//		
//		return "redirect:/profile/editComp/"  + compId;
//	}
    
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
		AddCompetenceFormValidator validator = new AddCompetenceFormValidator();
		validator.validate(form, result);
		if(result.hasErrors()){
			
			redirectedAttribtues.addFlashAttribute("addCompetenceForm", form);
			redirectedAttribtues.addFlashAttribute("org.springframework.validation.BindingResult.addCompetenceForm", result);
			
			return "redirect:profile?tab=tab2";
		}
		form.setOwnerId(user.getId());
		compService.saveCompetence(form);
		return "redirect:profile?tab=tab2";
		
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
			return "redirect:/profile";
		}
		User user = (User)session.getAttribute("user");
		form.setOwner(user);
		form.setDate(date);
		
		if(courseService.alreadyExists(form)){
			courseService.deleteCourse(form);
		}
		else{	
			try {
				courseService.save(form);
				redirectAttributes.addFlashAttribute("week", courseService.buildCalendar(date));
			} catch (ParseException e) {e.printStackTrace();}	
		}
    	return "redirect:/profile?tab=tab2";
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
	@RequestMapping(value="/profile/nextWeek/{dateString}/", method=RequestMethod.GET)
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
			return "redirect:/profile?tab=tab2";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Week week = courseService.buildCalendar(cal, user);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/profile?tab=tab2";
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
	@RequestMapping(value="/profile/lastWeek/{dateString}/", method=RequestMethod.GET)
	public String lastWeek(@PathVariable("dateString") String dateString, RedirectAttributes redirectAttributes,
			HttpSession session){
		
		Date date;
		User user = (User)session.getAttribute("user");
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/profile?tab=tab";
			
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Week week = courseService.buildCalendar(cal, user);
		redirectAttributes.addFlashAttribute("week", week);
		return "redirect:/profile?tab=tab2";
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
	@RequestMapping(value="/profile/houerlyRate", method=RequestMethod.POST)
	public String setHouerlyRate(@RequestParam("houerlyRate") String houerlyRateString, HttpSession session,
			RedirectAttributes redirAttributes){
		User user = (User) session.getAttribute("user");

		float houerlyRate;
		try{
			houerlyRate = Float.parseFloat(houerlyRateString);
		}
		catch(NumberFormatException e){
			redirAttributes.addFlashAttribute("houerlyError", "You can only get paied in money");
			return "redirect:/profile?tab=tab2";
		}
		if(houerlyRate < 0){
			redirAttributes.addFlashAttribute("houerlyError", "Houerly rate cannot be below zero");
		}
		else{
			userService.setHouerlyRate(user, houerlyRate);
		}
		return "redirect:/profile?tab=tab2";
	}
	
	/**
	 * Sets the grade for a {@link Competence}.
	 * 
	 * If the competenceGrade String cannot be parsed into a float, a error is added to the model and redirected.
	 * If the grade is not valid see({@link #gradeIsValid(float Grade)}) a error is added to the model and redir.
	 * 
	 * Otherwise, the {@Competence} is updated, and saved.
	 * 
	 * @param compId
	 * @param gradeString
	 * @param redirAttributes
	 * @return
	 */
	@RequestMapping(value="/profile/setGradeForCompetence/{compId}", method=RequestMethod.POST)
	public String setGradeForComp(@PathVariable("compId") long compId, @RequestParam("competenceGrade") String gradeString, 
			RedirectAttributes redirAttributes){
		//System.out.println("SetGrade[CompetenceId=" + compId + ", Grade=" + gradeString + "]");
		float grade;
		//TODO: check for null Competence?
		try{
			grade = Float.parseFloat(gradeString);
		}
		catch(NumberFormatException e){
			redirAttributes.addFlashAttribute("gradeError", "Only numbers");
			return "redirect:/profile?tab=tab2";
		}
		if(!gradeIsValid(grade)){
			redirAttributes.addFlashAttribute("gradeError", "Grade " + grade + " not valid");
			return "redirect:/profile?tab=tab2";
		}
		compService.setGrade(compId, grade);
		return "redirect:/profile?tab=tab2";
	}

	/**
	 * Validates a float 
	 * 
	 * 1 <= x <= 6
	 * 
	 * @param grade
	 * @return
	 */
	private boolean gradeIsValid(float grade) {
		return 0 <= grade && grade <= 6;
	}
}


