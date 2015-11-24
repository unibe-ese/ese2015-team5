package org.sample.controller.service;

import java.util.List;

import org.sample.controller.pojos.ApplicationForm;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.dao.ApplicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDao appDao;
	
	@Autowired 
	CourseService courseService;
	
	@Override
	public Application saveApplication(ApplicationForm form) {
		Application app = new Application();
		Course course = form.getCourse();
		app.setCourse(course);
		app.setMaster(course.getOwner());
		app.setSlave(form.getApplicant());
		return appDao.save(app);
	}

	@Override
	public Application findApplicationById(long appId) {
		return appDao.findOne(appId);
		
	}

	@Override
	public void deleteApplication(Application app) {
		app.setCourse(null);
		app.setMaster(null);
		app.setSlave(null);
		User user = app.getMaster();
		List<Application> apps;
		if(user != null){
			apps = user.getMyTutorApplications();
			apps.remove(app);
		}		
		user = app.getSlave();
		if(user != null){
			apps = user.getMyApplications();
			apps.remove(app);
		}
		appDao.delete(app);
		
	}

	@Override
	public Course acceptApplication(Application app) {
		Course course = courseService.settleCourseFromApplication(app);
		deleteApplication(app);
		return course;
	}
	
	
	

}
