package org.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.UserService;
import org.sample.model.Competence;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
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
    	
    	ModelAndView modelAndView = new ModelAndView("profile", model.asMap());
    	User user = userService.getCurrentUser();
    	if(user == null){
    		return new ModelAndView("index");
    	}
    	modelAndView.addObject("user", user);	
    	
    	if(!model.containsAttribute("modifyUserForm") ){
    	
    		ModifyUserForm modForm = new ModifyUserForm();
    		modForm.setEnableTutor(user.getEnableTutor());
    		modForm.setId(user.getId());
    		modelAndView.addObject("modifyUserForm", modForm);		
    	}
    	
    	if(!model.containsAttribute("addCompetenceForm") ){
    		modelAndView.addObject("addCompetenceForm", new AddCompetenceForm());
    	}
    	
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
		if(result.hasErrors() || !form.getPasswordControll().equals(form.getPassword())){
			
			redirectAttributes.addFlashAttribute("modifyUserForm", form);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modifyUserForm", result);			
			if(!form.getPasswordControll().equals(form.getPassword())){
				System.out.println("added PasswordControllerror");
				redirectAttributes.addFlashAttribute("passwordControllError", "Must match password");
			}
		}
		else if(userService.validateModifyUserForm(form)){	
			user = userService.updateUser(form);
		}
        return "redirect:profile";
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
        	System.out.println("if");
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
		System.out.println(userId);
		User visitee = userService.getUserById(userId);
		User visiter = userService.getCurrentUser();
		if(visitee == null){
			System.out.println("null");
			return "redirect:/index";
		}
		//TODO: Can a user view his profile as visitor?
		if(visitee.equals(visiter)){
			System.out.println("equsl");
			return "redirect:/profile";
		}
		System.out.println(visitee.toString());
		System.out.println(visiter.toString());
		model.addAttribute("visitee", visitee);
		System.out.println("public");
		return "publicProfile";
	}
	
}
