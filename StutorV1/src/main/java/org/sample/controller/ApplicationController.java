package org.sample.controller;

import org.sample.controller.service.ApplicationService;
import org.sample.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

	@Autowired 
	ApplicationService appService;
	
	@RequestMapping(value="/decline/{appId}", method=RequestMethod.GET)
	public String declineApplication(@PathVariable("appId") long appId){
		System.out.println("Decline: " + appId);
		Application app = appService.findApplicationById(appId);
		appService.deleteApplication(app);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/accept/{appId}", method=RequestMethod.GET)
	public String acceptApplication(@PathVariable("appId") long appId){
		System.out.println("Accept: " + appId);
		Application app = appService.findApplicationById(appId);
		appService.acceptApplication(app);
		return "redirect:/index";
	}
	
	
	
}
