package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.pojos.ModifyUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/profile/*")
public class ProfileController {
	
	@RequestMapping(value="/profile/editUser", method=RequestMethod.POST)
	public ModelAndView modifyUser(@Valid ModifyUserForm form, BindingResult result, RedirectAttributes redirectAttributes){
		
		System.out.println(form.getPasswordControll());
		return null;
	}
	
}
