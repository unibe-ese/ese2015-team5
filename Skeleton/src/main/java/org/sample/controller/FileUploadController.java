package org.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.controller.service.SampleService;
import org.sample.controller.service.UserService;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	 @Autowired
	 SampleService sampleService;
	 
	 @Autowired
	 UserService userService;
	 
	/**
	 * @Deprecated
	 * 
	 * @return 
	 */
	@Deprecated
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView uploadForm(){
		ModelAndView model = new ModelAndView("upload");
		return model;
	}
	
	/**
	 * Displays the profile picture of a user.
	 * 
	 * Takes a user ID, and checks if a user with said ID exists. If one exists, 
	 * gets the the users profile picture, and fills it into the response, which is 
	 * sent to the client. 
	 * 
	 * @param userId  The ID of the user
	 * @param response  The response to the request of the client.
	 * @param request   A request from a client
	 * @throws ServletException  
	 * @throws IOException
	 */
	@RequestMapping(value = "/imageDisplay$userId={userId}", method = RequestMethod.GET)
	  public void showImage(@PathVariable("userId") long userId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		User user = userService.getUserById(userId);
		if(user != null){
			ProfilePicture item = user.getPic(); 
	    	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    	response.getOutputStream().write(item.getFile());
	    	response.getOutputStream().close();
		}
		
	}
	
	/**
	 * Validates and saves a picture to the DB.
	 * 
	 * Receives a Multipart File, checks if its empty.
	 * If the File is valid, creates a profiePicture object, and adds the file to the object.
	 * If an excetion is thrown, returns null;
	 * 
	 * @param file:  A  multipart file containint a picture.
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile file) {
 
        if (!file.isEmpty()) {
            try {
            	ProfilePicture profilePicture = new ProfilePicture();
            	
            	profilePicture.setFile(file.getBytes());
            	
            	sampleService.saveProfilePicture(profilePicture);
            	
            	ModelAndView model = new ModelAndView("show");
            	
                return model;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
