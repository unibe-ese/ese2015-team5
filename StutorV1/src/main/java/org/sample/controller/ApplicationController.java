package org.sample.controller;

import org.sample.controller.pojos.MessageForm;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.UserService;
import org.sample.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests that modify applications.
 * 
 * @author hess
 *
 */


@Controller
public class ApplicationController {

	
	@Autowired 
	ApplicationService appService;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	MessageService msgService;
	
    @Autowired
    public ApplicationController(UserService userService, ApplicationService appService){
    	this.userService = userService;
    	this.appService  = appService;
    }
	
	/**
	 * Handles a request that declines an application.
	 * It is checked, if the currently logged in {@link org.sample.model.User}
	 * has the right to decline the application. That is, when he is the tutor for this
	 * application. 
	 * The application cannot be null (is tested), otherwise a NullPointerException would be thrown
	 * when the application is removed from the according {@link org.sample.model.User}'s list.
	 * {@link org.sample.controller.service.ApplicationServiceImpl#deleteApplication(Application app) 
	 * deleteApplication(Application app)}
	 * 
	 * @param appId: Id for a Application
	 * @return to the Index page.
	 */
	@RequestMapping(value="/decline/{appId}", method=RequestMethod.GET)
	public String declineApplication(@PathVariable("appId") long appId){
		Application app = appService.findApplicationById(appId);
		if(app != null && userService.getCurrentUser().equals(app.getTutor()))
			appService.deleteApplication(app);
		return "redirect:/index";
	}
	
	/**
	 * Handles a request to accept a application.
	 * It's checked, if the logged in {@link org.sample.model.User User} has the permission
	 * to accept the application. (If he is the tutor of the {@link Application}).
	 * It is also checked, that the {@link Application} is not null.
	 * If these conditions are met, the Application is accepted 
	 * {@link org.sample.controller.service.ApplicationServiceImpl#acceptApplication(Application app) acceptApplication(Application app)}
	 * 
	 * 
	 * @param appId: Id for a Application
	 * @return to the Index page.
	 */
	@RequestMapping(value="/accept/{appId}", method=RequestMethod.GET)
	public String acceptApplication(@PathVariable("appId") long appId){
		Application app = appService.findApplicationById(appId);
		if(app != null && userService.getCurrentUser().equals(app.getTutor())){
			appService.acceptApplication(app);
			MessageForm msgForm = new MessageForm();
			msgForm.setTitle("Application Accepted");
			msgForm.setMessage(userService.getCurrentUser().getFirstName() + " " + userService.getCurrentUser().getLastName() +
					" has been added to your contacts." +
					"Contact your tutor to exchange further information.");
			msgService.saveMessage(msgForm, userService.getCurrentUser(), app.getStudent());
		}
		return "redirect:/index";
	}
	
	
	
}
