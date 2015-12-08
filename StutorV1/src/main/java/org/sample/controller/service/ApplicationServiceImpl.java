package org.sample.controller.service;

import java.util.ArrayList;
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
	
	@Autowired
	UserService userService;
	
	@Override
	public Application saveApplication(ApplicationForm form) {
		Application app = new Application();
		Course course = form.getCourse();
		app.setCourse(course);
		app.setTutor(course.getOwner());
		app.setStudent(form.getApplicant());
		return appDao.save(app);
	}

	@Override
	public Application findApplicationById(long appId) {
		return appDao.findOne(appId);
		
	}

	@Override
	public void deleteApplication(Application app) {
		app.setCourse(null);
		User user = app.getTutor();
		List<Application> apps;
		if(user != null){
			apps = user.getMyTutorApplications();
			apps.remove(app);
		}		
		user = app.getStudent();
		if(user != null){
			apps = user.getMyApplications();
			apps.remove(app);
		}
		app.setTutor(null);
		app.setStudent(null);
		appDao.delete(app);
		
	}

	@Override
	public Course acceptApplication(Application app) {
		Course course = courseService.settleCourseFromApplication(app);
		deleteApplication(app);
		return course;
	}

	
	@Override
	public List<Application> getFutureApplications() {
		User user = userService.getCurrentUser();
		List<Application> apps = user.getMyTutorApplications();
		List<Application> toRemove = new ArrayList<Application>();
		for(Application app : apps){
			if(app.isInThePast()){
				toRemove.add(app);
			}
		}
		for(Application app : toRemove){
			apps.remove(app);
		}
		appDao.delete(toRemove);
		return apps;
	}

	@Override
	public boolean notDuplicate(ApplicationForm application) {
		for(Application app : application.getApplicant().getMyApplications()){
			if(app.getCourse().equals(application.getCourse())){
				return false;
			}
		}
		return true;
	}
	
	
	

}
