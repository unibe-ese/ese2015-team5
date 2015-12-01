package org.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.sample.controller.pojos.MessageForm;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.UserService;
import org.sample.model.Course;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MessageController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService msgService;
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public String showMessages(Model model){
		User user = userService.getCurrentUser();
		
		model.addAttribute("sentMessages", user.getSentMessages());
		model.addAttribute("receivedMessages", user.getReceivedMessages());
		
		List<Course> courses = user.getCourses();
		ArrayList<User> contacts = new ArrayList<User>();
		for (Course c : courses){
			if (c.getCustomer() != null && c.getOwner() != null){
				contacts.add(c.getCustomer().equals(user) ? c.getOwner() : c.getCustomer());
			}
		}
		
		model.addAttribute("contacts", contacts);
		
		if (!model.containsAttribute("messageForm")){
			model.addAttribute("messageForm", new MessageForm());
		}
		
		
		return "message";
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
