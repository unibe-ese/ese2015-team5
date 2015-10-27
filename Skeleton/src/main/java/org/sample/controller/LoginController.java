package org.sample.controller;

import org.sample.controller.pojos.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam(value="error", required=false) boolean error, ModelMap model) {
    
     // Add an error message to the model if login is unsuccessful
     // The 'error' parameter is set to true based on the when the authentication has failed. 
     // We declared this under the authentication-failure-url attribute inside the spring-security.xml
     /* See below:
      <form-login 
       login-page="/krams/auth/login" 
       authentication-failure-url="/krams/auth/login?error=true" 
       default-target-url="/krams/main/common"/>
      */
     if (error == true) {
      // Assign an error message
      model.put("error", "You have entered an invalid username or password!");
     } else {
      model.put("error", "");
     }
      
     // This will resolve to /WEB-INF/jsp/loginpage.jsp
     
     ModelAndView view = new ModelAndView("home");
     view.addObject(new RegistrationForm());
     
     return view;
    }
}
