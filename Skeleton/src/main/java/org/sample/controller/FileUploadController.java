	package org.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.controller.service.SampleService;
import org.sample.model.ProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	 @Autowired
	 SampleService sampleService;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView uploadForm(){
		ModelAndView model = new ModelAndView("upload");
		return model;
	}
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


	    ProfilePicture item = sampleService.getProfilePicture();    
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getFile());
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
 
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
