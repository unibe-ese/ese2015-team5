package org.sample.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.sample.controller.pojos.MessageForm;
import org.sample.controller.service.CourseService;
import org.sample.controller.service.MessageService;
import org.sample.controller.service.UserService;
import org.sample.model.Course;
import org.sample.model.Message;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MessageController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService msgService;
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public String showMessages(Model model){
		User user = userService.getCurrentUser();
		
		List<Message> messages = new ArrayList<Message>();
		messages = user.getSentMessages();
		Collections.sort(messages, new Comparator<Message>() {
		    @Override
		    public int compare(Message m1, Message m2) {
		    	
		        return m2.getDate().compareTo(m1.getDate());
		    }
		});
		model.addAttribute("sentMessages", messages);
		messages = user.getReceivedMessages();
		Collections.sort(messages, new Comparator<Message>() {
		    @Override
		    public int compare(Message m1, Message m2) {
		    	
		        return m2.getDate().compareTo(m1.getDate());
		    }
		});
		model.addAttribute("receivedMessages", messages);
		
		ArrayList<User> tutors = new ArrayList<User>();
		Collection<Course> myTutorCourses = courseService.findStudenCoursesFor(user);
		
		for (Course c : myTutorCourses){
			if (c.getCustomer() != null && c.getOwner() != null){
				User contact = c.getCustomer().equals(user) ? c.getOwner() : c.getCustomer();
				if (!tutors.contains(contact)){
					tutors.add(contact);
				}
			} 
		}
		
		ArrayList<User> tutees = new ArrayList<User>();
		List<Course> myCourses = user.getCourses();
		
		for (Course c : myCourses){
			if (c.getCustomer() != null && c.getOwner() != null){
				User contact = c.getCustomer().equals(user) ? c.getOwner() : c.getCustomer();
				if (!tutees.contains(contact)){
					tutees.add(contact);
				}
			}
		}
		
		model.addAttribute("tutors", tutors);
		model.addAttribute("tutees", tutees);
		
		return "message";
	}
	
	@RequestMapping(value="/newMessage", method=RequestMethod.POST)
	public String newMessage(Model m, @RequestParam("id") long id){
		
		MessageForm form = new MessageForm();
		form.setRecipient(userService.getUserById(id));
		m.addAttribute("messageForm", form);		
		
		return "newMessage";
		
	}
	
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute("messageForm") MessageForm msgForm, BindingResult result, 
			RedirectAttributes redirectedAttribtues ){
		
		User sender = userService.getCurrentUser();
		User recipient = userService.getUserById(msgForm.getUserId());
		msgService.saveMessage(msgForm, sender, recipient);
		
		return "redirect:/messages?tab=tab2";
		
	}
	
	

}
