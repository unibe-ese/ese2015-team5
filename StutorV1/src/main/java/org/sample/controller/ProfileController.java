package org.sample.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.pojos.ApplicationForm;
import org.sample.controller.pojos.MessageForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.ModifyUserFormValidator;
import org.sample.controller.service.UserService;
import org.sample.model.Application;
import org.sample.model.Competence;
import org.sample.model.Course;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.Week;
import org.sample.model.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests that display the profile and modify the {@link org.sample.model.User User}.
 * Contains methods to modify the user information, change the {@link ProfilePicture}, and add/remove
 * {@link Competence}s.
 * 
 * 
 * @author ESE Team5
 *
 */

@Controller
@SessionAttributes("user")
public class ProfileController {
	
	private static final String[] hours = {"00:00 - 01:00" , "01:00 - 02:00", "02:00 - 03:00" , "03:00 - 04:00" , "04:00 - 05:00" , 
		"05:00 - 06:00", "06:00 - 07:00", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00",
		"10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00" , 
		"15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00",
		"20:00 - 21:00", "21:00 - 22:00", "22:00 - 23:00", "23:00 - 24:00"};
	
	
	@Autowired 
	UserService userService;
	@Autowired
	CompetenceService compService;
	@Autowired 
	CourseService courseService;
	@Autowired
	ApplicationService appService;
	@Autowired
	MessageService msgService;
	
	
	@Autowired
	public ProfileController(UserService userService, CompetenceService compService, CourseService courseService, ApplicationService appService){
		this.userService = userService;
		this.compService = compService;
		this.courseService = courseService;
		this.appService = appService;
	}
	
	
	
	
	
	/**
	 * Displays the correct profile page.
	 * 
	 * Receives the model from the previous page. The model is filled with the necessary
	 * Objects, depending on if it already contains an instance of them.
	 * {@link #buildProfileModel(Model model, User user)} 
	 * 
	 * 
	 * @param model
	 * @return 
	 */
    @RequestMapping( value = "/tutorProfile")
    public ModelAndView gotoProfile(Model model){
  	
    	User user = userService.getCurrentUser();
    	if(user == null){
    		return new ModelAndView("index");
    	}   	
    	ModelAndView modelAndView = new ModelAndView("generalProfile", buildProfileModel(model, user).asMap());
    	if(user.getEnableTutor())
    	{
    		modelAndView = new ModelAndView("tutorProfile", buildProfileModel(model, user).asMap());
    	}
    	assert modelAndView != null;
    	return modelAndView;
    }

    /**
     * Builds a model for the profile page of the {@link User}.
     * Checks if the model already contains certain attributes ({@link org.sample.controller.pojos.ModifyUserForm modifyUserForm}, {@link org.sample.controller.pojos.AddCompetenceForm addCompetenceForm}
     * {@link org.sample.model.Week week}, {@link org.sample.controller.pojos.AddCourseForm addCourseForm}.
     * The modifyUserForm is filled with the user data it will display in the profile page. {@link #buildModForm(User user)}.
     * The {@link Week} is built with {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
     * 
     * @param model: Model of the prevoius page.
     * @param user: Currently logged in user.
     * @return: The model for the profile page.
     */
	private Model buildProfileModel(Model model, User user) {
		model.addAttribute("user", user);	

    	if(!model.containsAttribute("modifyUserForm") ){
    		model.addAttribute("modifyUserForm", buildModForm(user));		
    	}
    	
    	if(!model.containsAttribute("addCompetenceForm") ){
    		model.addAttribute("addCompetenceForm", new AddCompetenceForm());
    	}
    	if(!model.containsAttribute("week")){
    		Week week = courseService.buildCalendar(Calendar.getInstance(), user);
    		model.addAttribute("week", week);
    	}
		
		model.addAttribute("hours", hours);
    	
    	model.addAttribute("addCourseForm", new AddCourseForm());
    	return model;
	}

	/**
	 * Fills a {@link ModifyUserForm} with the information of a {@link User}
	 * 
	 * @param user
	 * @return
	 */
	private ModifyUserForm buildModForm(User user) {
		ModifyUserForm modForm = new ModifyUserForm();
		modForm.setEnableTutor(user.getEnableTutor());
		modForm.setId(user.getId());
		return modForm;
	}	
    
    /**
     * Checks if modified information is valid, then saves it/displays errors. 
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
     * @throws UnsupportedEncodingException 
     * @throws InvalidUserException 
     */
    @RequestMapping(value="/modifyUser", method=RequestMethod.POST)
	public String modifyUser( @ModelAttribute("user") User user, 
			ModifyUserForm form, BindingResult result, RedirectAttributes redirectAttributes) throws InvalidUserException, UnsupportedEncodingException{
		form.setId(user.getId());
		ModifyUserFormValidator validator = new ModifyUserFormValidator();
		validator.validate(form, result);
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("modifyUserForm", form);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modifyUserForm", result);
			return "redirect:/tutorProfile?edit=fail";
		}
		else if(userService.validateModifyUserForm(form)){	
			user = userService.updateUser(form);
			return "redirect:/tutorProfile?edit=success";
		}
        return "redirect:/index";
	}
	
	/**
	 * Validates and saves a picture to the DB.
	 * 
	 * Receives a MultipartFile, checks if its empty.
	 * If the File is valid, creates a profiePicture object, and adds the file to the object.
	 * If an exception is thrown, returns redirects to the profile page and does't change the profile
	 * picture. 
	 * 
	 * 
	 * @param file:  A  multipartFile containing a picture.
	 * @return: Redirects to the profile page. 
	 */
	@RequestMapping(value = "/changeProfilePic", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile file, RedirectAttributes redir) {
        if (!file.isEmpty()) {
            try {
            	ProfilePicture profilePicture = new ProfilePicture();
            	
            	profilePicture.setFile(file.getBytes());
            	
            	userService.updateProfilePicture(profilePicture);
            	
                return "redirect:tutorProfile";
            } catch (Exception e) {
            	e.printStackTrace();
            	redir.addFlashAttribute("pictureError", "Picture could not be processed");
                return "redirect:tutorProfile";
            }
        }else{       	
        	redir.addFlashAttribute("pictureError", "Picture cannot be empty");
        	return "redirect:tutorProfile";
        }
    }
	
	/**
	 * Displays the profile picture of a user.
	 * 
	 * Takes a user ID, and checks if a user with said ID exists. If one exists, 
	 * gets the the users profile picture, and fills it into the response, which is 
	 * sent to the client. 
	 * 
	 * @param userId  The ID of the user
	 * @param response  The response to the request of the client.
	 * @param request   A request from a client
	 * @throws ServletException  
	 * @throws IOException
	 */
	@RequestMapping(value = "/imageDisplay$userId={userId}", method = RequestMethod.GET)
	public void showImage(@PathVariable("userId") long userId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		User user = userService.getUserById(userId);
		if(user != null){
			ProfilePicture item = user.getPic(); 
	    	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    	response.getOutputStream().write(item.getFile());
	    	response.getOutputStream().close();
		}
		
	}
	
	/**
	 * Handles requests to display the profile of another user.
	 * 
	 * When a user requests to see his own profile, he is redirected to the "normal" view of his profile.
	 * {@link #gotoProfile(Model model)}
	 * If the userId doesnt correspond to a {@link User}, redirects to index.
	 * If a corresponding {@link User} has been found, attribtues are added to the model.
	 * 
	 * <p>-{@link Week} is built with {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}
	 * The current date is passed to the method.</p>
	 * <p>-A {@link ApplicationForm} is added.
	 * 
	 * @param userId: Id of the user you would like to visit.
	 * @param model: Model from the previous model. 
	 * @return
	 */	
	@RequestMapping(value="/tutorProfile/{userId}", method=RequestMethod.GET)
	public String showPublicProfile(@PathVariable long userId, Model model, RedirectAttributes red){
		User visitee = userService.getUserById(userId);
		User visiter = userService.getCurrentUser();
		if(visitee == null || visiter == null){
			return "redirect:/index";
		}
		if(visitee.equals(visiter)){
			
			return "redirect:/tutorProfile";
		}
		model.addAttribute("visitee", visitee);
		if(!model.containsAttribute("week")){
			model.addAttribute("week", courseService.buildCalendar(Calendar.getInstance(), visitee));
		}
		
		model.addAttribute("hours", hours);
		model.addAttribute("application", new ApplicationForm());
		
		return "publicProfile";
	}
	
	/**
	 * Handles requests to display the next {@link Week} of a calendar for a public profile.
	 * 
	 * <p>Builds a week for the {@User} with ID userId;</p>
	 * <p>The requested date is retrieved from the dateString, which is parsed with {@link org.sample.model.WeekDay#FORMAT Week.FORMAT}</p>
	 * 
	 * The week is then added to redirectAttributes, so when redirecting to {@link #gotoProfile(Model model) /tutorProfile}
	 * If the dateString cannot be parsed, redirects to profile.
	 * 
	 * 
	 * @param userId: ID refering a {@link User}
	 * @param dateString: String representation of a Date. "dd.MM.yyyy" can be parsed.
	 * @return Redirects to profile/userID
	 */
	@RequestMapping(value="/tutorProfile/{userId}/nextWeek/{dateString}/", method=RequestMethod.GET)
	public String showPublicProfileNextWeek(@PathVariable long userId, @PathVariable("dateString") String dateString, RedirectAttributes redirAttributes){
		User visitee = userService.getUserById(userId);
		if(visitee == null){
			return "redirect:/index";
		}
		Date date;
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/tutorProfile/" + userId;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 7);
		redirAttributes.addFlashAttribute("week", courseService.buildCalendar(cal, visitee));
		return "redirect:/tutorProfile/" + userId;
	}
	
	/**
	 * Handles requests to display the last {@link Week} of a calendar for a public profile.
	 * 
	 * <p>Builds a week for the {@User} with ID userId;</p>
	 * <p>The requested date is retrieved from the dateString, which is parsed with {@link org.sample.model.WeekDay#FORMAT Week.FORMAT}</p>
	 * 
	 * The week is then added to redirectAttributes, so when redirecting to {@link #gotoProfile(Model model) /tutorProfile}
	 * If the dateString cannot be parsed, redirects to profile.
	 * 
	 * 
	 * @param userId: ID refering a {@link User}
	 * @param dateString: String representation of a Date. "dd.MM.yyyy" can be parsed.
	 * @return Redirects to tutorProfile/userID
	 */
	@RequestMapping(value="/tutorProfile/{userId}/lastWeek/{dateString}/", method=RequestMethod.GET)
	public String showPublicProfileLastWeek(@PathVariable long userId, @PathVariable("dateString") String dateString, RedirectAttributes redirAttributes){
		User visitee = userService.getUserById(userId);
		if(visitee == null){
			return "redirect:/index";
		}
		Date date;
		try {
			date = WeekDay.FORMAT.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/tutorProfile/" + userId;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		redirAttributes.addFlashAttribute("week", courseService.buildCalendar(cal, visitee));
		return "redirect:/tutorProfile/" + userId;
	}
	
	/**
	 * Adds a {@link org.sample.model.Application Application} for a {@link org.sample.model.Course Course}.
	 * 
	 * Gets the ID of a {@link org.sample.model.Course Course}, and attempts to create a Application
	 * for the Course. Checks for following things:
	 * <p>- If the Course is available. (not booked yet) @see{@link org.sample.controller.service.CourseServiceImpl#courseIsAvailable(Course course) 
	 * courseIsAvailable(Course course)}. </p>
	 * <p>- The Course is not a duplicate (The customer hasn't already sent an Application 
	 * see{@link org.sample.controller.service.ApplicationServiceImpl#notDuplicate(ApplicationForm application) notDuplicate}
	 * </p>
	 * If these conditions are met, the application is saved with 
	 * {@link org.sample.controller.service.ApplicationServiceImpl#saveApplication(ApplicationForm application) 
	 * saveApplication()}, then returns to profile page.
	 * 
	 * @param courseId: A ID that corresponds to a {@link Course}
	 * @return to the public profile page.
	 */
	@RequestMapping(value="/tutorProfile/application", method=RequestMethod.POST)
	public String addApplication(@RequestParam("courseId") long courseId, RedirectAttributes redir){
		ApplicationForm applicationForm = buildAppForm(courseId);
		Application app;
		if(courseService.courseIsAvailable(applicationForm.getCourse()) && appService.notDuplicate(applicationForm)){
			app = appService.saveApplication(applicationForm);
			redir.addFlashAttribute("week", courseService.buildCalendar(app.getDate(), app.getTutor()));
			redir.addFlashAttribute("pageSuccess", "Application has been sent (See your messenger for further information)");
			MessageForm msgForm = new MessageForm();
			msgForm.setTitle("Application");
			msgForm.setMessage(app.getStudent().getFirstName() + " " + app.getStudent().getLastName() + 
					" has sent an application for " + app.getDateRepresentation() + "After you accept, " +
					"the student will be added to your contacts and you can exchange further information.");
			msgService.saveMessage(msgForm, app.getStudent(), app.getTutor());
			return "redirect:/tutorProfile/" + app.getTutor().getId();
		}
		redir.addFlashAttribute("pageError", "Could not send Application.<br> -Was it in the past? <br> -Did you already apply?");
		return "redirect:/tutorProfile/" + applicationForm.getCourse().getOwner().getId();
	}

	/**
	 * Builds a {@link ApplicationForm} for {@link org.sample.model.Course Course}, given a courseId.
	 * 
	 * @param courseId
	 * @return
	 */
	private ApplicationForm buildAppForm(long courseId) {
		ApplicationForm application = new ApplicationForm();
		
		application.setCourse(courseService.getCourseById(courseId));
		application.setApplicant(userService.getCurrentUser());
		return application;
	}
	
	
	
	
	
}
