package org.sample.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sample.controller.pojos.NewsFeedArticleInterface;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.CompetenceService;
import org.sample.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles request that originate from the index page.
 * 
 * Also handles the search function for {@link org.sample.model.Competence}
 *
 *@Author: ESE Team 5
 *
 */

@Controller
public class IndexController {

    @Autowired
    CompetenceService compService;
    
    @Autowired 
    UserService userService;
    
    @Autowired
    ApplicationService appService;

    /**
     * Displays the index page.
     * 
     * Adds a list of competences to the model and then returns the {@link ModelAndView} of the index page.
     * 
     * @return {@link ModelAndView} of index.
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model modelo) {  	
    	ModelAndView model = buildIndexModel();
    	model.addObject("competence", modelo.asMap().get("competences"));
    	assert model != null;
        return model;
    }
    
    private ModelAndView buildIndexModel() {
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("applications", appService.getFutureApplications());
    	List<NewsFeedArticleInterface> news = userService.buildNewsFeed();
    	model.addObject("newsfeed", news);
    	return model;
	}

//	/**
//     * Not used. Will be used, if the searchCompetenceLike redirects to the index page. 
//     * @param model
//     * @return
//     */
//    public ModelAndView index(Model model) {
//    	System.out.println("index");
//    	ModelAndView newModel = new ModelAndView("index", model.asMap());   
//    	if(!model.containsAttribute("competences")){
//    		newModel.addObject("competences", compService.findCompetenceLike(""));
//    	}
//    	assert newModel != null;
//        return newModel;
//    }
    
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "access-denied";
    }
    
    
    /**
     * Handles requests that search for {@link org.sample.model.Competence}
     * 
     * Receives a String, and searches the DB for Competences that contain the String in 
     * their description, and are enabled. So only if the owner offers tutoring at the moment the competence
     * is added. Then returns the user to the index, displaying the found Competences.
     * 
     * @param request: A request containing a searchQuery.
     * @return A {@link ModelAndView} of the index page. 
     */
    @RequestMapping(value="/findCompetenceLike", method=RequestMethod.GET)
    public String findCompetenceLike(HttpServletRequest request, RedirectAttributes redirAttribtues){
    	String searchQuery = request.getParameter("searchQuery");
    	redirAttribtues.addFlashAttribute("competences", compService.findCompetenceLike(searchQuery));
    	return "redirect:/index";
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have permission to do that!");
        return "redirect:/";
    }

    
    

}


