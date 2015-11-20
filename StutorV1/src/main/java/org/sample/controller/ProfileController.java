package org.sample.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.UserService;
import org.sample.model.Competence;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.Week;
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
 * Handles requests that display the profile and modify the {@link org.sample.model.User}.
 * Contains methods to modify the user information, change the {@link ProfilePicture}, and add/remove
 * {@link Competence}s.
 * 
 * @author ESE Team5
 *
 */

@Controller
@SessionAttributes("user")
public class ProfileController {
	
	@Autowired 
	UserService userService;
	@Autowired
	CompetenceService compService;
	@Autowired 
	CourseService courseService;
	
	/**
	 * Displays the correct profile page.
	 * 
	 * Receives the model from the previous page. The model is filled with the necessary
	 * Objects, depending on if it already contains an instance of them. 
	 * 
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping( value = "/profile")
    public ModelAndView gotoProfile(Model model){
  	
    	User user = userService.getCurrentUser();
    	if(user == null){
    		return new ModelAndView("index");
    	}   	
    	  	
    	ModelAndView modelAndView = new ModelAndView("profile", buildProfileModel(model, user).asMap());
    	return modelAndView;
    }

	private Model buildProfileModel(Model model, User user) {
		model.addAttribute("user", user);	
    	
    	if(!model.containsAttribute("modifyUserForm") ){
    		model.addAttribute("modifyUserForm", buildModForm(user));		
    	}
    	
    	if(!model.containsAttribute("addCompetenceForm") ){
    		model.addAttribute("addCompetenceForm", new AddCompetenceForm());
    	}
    	if(!model.containsAttribute("calendar")){
    		Week week = courseService.buildCalendar(Calendar.getInstance());
    		for(int i = 0; i < week.getWeekDays().length; i++){
    			System.out.println(week.getWeekDays()[i].getDate().getTime());
    			System.out.println(week.getWeekDays()[i].toString());
    		}
    		model.addAttribute("week", week);
    	}
    	
    	return model;
	}

	private ModifyUserForm buildModForm(User user) {
		ModifyUserForm modForm = new ModifyUserForm();
		modForm.setEnableTutor(user.getEnableTutor());
		modForm.setId(user.getId());
		return modForm;
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
		if(result.hasErrors() || !form.getPasswordControll().equals(form.getPassword())){
			
			redirectAttributes.addFlashAttribute("modifyUserForm", form);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modifyUserForm", result);			
			if(!form.getPasswordControll().equals(form.getPassword())){
				redirectAttributes.addFlashAttribute("passwordControllError", "Must match password");
			}
		}
		else if(userService.validateModifyUserForm(form)){	
			user = userService.updateUser(form);
		}
        return "redirect:profile";
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
    public String uploadFileHandler(@RequestParam("file") MultipartFile file) {
		try {
			System.out.println(file.getBytes().toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (!file.isEmpty()) {
            try {
            	ProfilePicture profilePicture = new ProfilePicture();
            	
            	profilePicture.setFile(file.getBytes());
            	
            	userService.updateProfilePicture(profilePicture);
            	
                return "redirect:profile";
            } catch (Exception e) {
                return "redirect:profile";
            }
        }else{       	
        	return "redirect:profile";
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
	
	@RequestMapping(value="/profile/{userId}", method=RequestMethod.GET)
	public String showPublicProfile(@PathVariable long userId, Model model){
		User visitee = userService.getUserById(userId);
		User visiter = userService.getCurrentUser();
		if(visitee == null){
			return "redirect:/index";
		}
		//TODO: Can a user view his profile as visitor?
		if(visitee.equals(visiter)){
			
			return "redirect:/profile";
		}
		model.addAttribute("visitee", visitee);
		return "publicProfile";
	}
	
}
