package org.sample.controller;

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
	 * Deletes a competence
	 * 
	 * Uses the CompetenceService to delete a competence. If there is no competence with the correct ID, 
	 * the method does nothing.
	 * 
	 * @param compId The id of the competence.
	 * @return Redirects to the profile page.
	 */
	@RequestMapping(value="/profile/delete$id={compId}", method=RequestMethod.GET)
	public String deleteCompetence(@PathVariable("compId")long compId){
		Competence comp = compService.findCompetenceById(compId);
		if(comp != null){
			compService.deleteCompetence(comp);
		}
		return "redirect:/profile";
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
	
}
