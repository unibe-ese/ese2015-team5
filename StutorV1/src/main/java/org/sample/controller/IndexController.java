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
     * Adds object competences from previous Model to the new model.
     * Calls {@link #buildIndexModel()}, which adds the correct objects to the model.

     * @return {@link ModelAndView} of index.
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model modelo) {  	
    	ModelAndView model = buildIndexModel();
    	model.addObject("competence", modelo.asMap().get("competences"));
    	assert model != null;
        return model;
    }
    
    /**
     * Builds the model for the index page by adding the correct objects to the {@link ModelAndView}
     * 
     * Retrieves {@link Application}s from the DB concerning the logged in {@link org.sample.model.User User}.
     * Adds a List of {@link org.sample.controller.pojos.NewsFeedArticleInterface NewsFeedArticles} to the Model.
     * {@link org.sample.controller.service.UserServiceImpl#buildNewsFeed() buildNewsFeed()}
     * 
     * @return the index model.
     */
    private ModelAndView buildIndexModel() {
    	ModelAndView model = new ModelAndView("index");   
    	model.addObject("applications", appService.getFutureApplications());
    	List<NewsFeedArticleInterface> news = userService.buildNewsFeed();
    	model.addObject("newsfeed", news);
    	return model;
	}
    
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


