package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.LoginForm;

/*
 * The HomeController
 */

@Controller
public class HomeController {

	/**
	 * This method is connected to the empty url {some host}/ and to the request
	 * type GET
	 * 
	 * Possible returns: ModelAndView View String (pointing to the jsp file)
	 * 
	 * @see pojo.LoginForm
	 * 
	 *      Next step: try to connect it to multiple possible urls like: /home
	 *      /login
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {

		/*
		 * Creates a view called home Home is directed to the /views/home.jsp
		 * file The view is an object based on the home.jsp file You can have
		 * multiple views and each could be modified individually
		 */
		ModelAndView model = new ModelAndView("home");

		/*
		 * Now we assign models to the view That means we bind objects (pojos^^)
		 * to the view In this case we give an empty model LoginForm that we
		 * expect to get filled afterwards
		 */
		model.addObject("value", "that's soooo smart dude");
		model.addObject("loginForm", new LoginForm());

		/*
		 * At the end we return the view and it will be displayed by the
		 * framework
		 */
		return model;
	}

	/**
	 * This method is connected to the empty url {some host}/ and to the
	 * request type POST
	 * 
	 * This method will get called if the user presses the submit button from the login form
	 * The model that we already binded to the view holds now the variables passed by the user
	 * The framework calls automatically the setters method of each PATH variable in the jsp file
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(LoginForm loginForm) {

		return new ModelAndView("home", "value", loginForm.getEmail());
	}
}
