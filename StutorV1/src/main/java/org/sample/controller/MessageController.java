package org.sample.controller;

import org.sample.controller.pojos.MessageForm;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.UserService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MessageController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService msgService;
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public ModelAndView showMessages(Model m){
		User user = userService.getCurrentUser();
		
		
		ModelAndView model = new ModelAndView("message");
		model.addObject("sentMessages", user.getSentMessages());
		model.addObject("receivedMessages", user.getReceivedMessages());
		model.addObject("messageForm", new MessageForm());
		
		
		
		return model;
	}
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute("messageForm") MessageForm msgForm, BindingResult result, 
			RedirectAttributes redirectedAttribtues ){
		
		User sender = userService.getCurrentUser();
		User recipient = userService.getUserByEmail(msgForm.getRecipient());
		msgService.saveMessage(msgForm, sender, recipient);
		return "redirect:/messages?tab=tab2";
		
	}
	
	

}
