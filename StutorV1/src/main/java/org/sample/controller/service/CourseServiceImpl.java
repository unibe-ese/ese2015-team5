package org.sample.controller.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.sample.controller.pojos.AddCourseForm;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.Week;
import org.sample.model.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired 
	CourseDao courseDao;
	@Autowired 
	UserService userService;
	

	@Override
	public Week buildCalendar(Calendar cal) {
		User user = userService.getCurrentUser();
		return buildCalendar(cal, user);
	}
	

	@Override
	public Object buildCalendar(Date date) {
		User user = userService.getCurrentUser();
		return buildCalendar(date, user);
	}
	
	@Override
	public Week buildCalendar(Date date, User user) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return buildCalendar(cal, user);
	}
		
	@Override
	public Week buildCalendar(Calendar instance, User user) {
		Week week = Week.buildWeek(instance);
		return findAllForWeek(week, user);
		
	}

	private Week findAllForWeek(Week week, User user) {
		List<Course> courses = user.getCourses();		
			for(Course course : courses){
				if(course.isDuring(week)){
					Calendar cal = Calendar.getInstance();
					cal.setTime(course.getDate());
					int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
					dayOfWeek = computeArraySlot(dayOfWeek);
					week.getWeekDays()[dayOfWeek].addCourse(course);
				}			
		}
		return week;
	}

	private int computeArraySlot(int dayOfWeek) {
		int tempInt = dayOfWeek - 2;
		if(tempInt < 0)
			return 7 - dayOfWeek;
		return tempInt;
	}

	@Override
	public Course save(AddCourseForm form){
		User user = form.getOwner();
		if(user != null){
			Course course = new Course();
			course.setOwner(user);
			course.setDate(form.getDate());
			course.setSlot(form.getSlot());
			course.setAvailable(true);
			return courseDao.save(course);
		}
		return null;
	}


	@Override
	public boolean alreadyExists(AddCourseForm form) {	
		for(Course c : form.getOwner().getCourses()){
			if(c.sameDay(form.getDate()) && c.getSlot() == form.getSlot()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Only call after alreadyExists
	 */
	@Override
	public void deleteCourse(AddCourseForm form) {
		Course course = findCourseFromForm(form);
		if(course != null){
			course.setOwner(null);
			courseDao.delete(course);
		}
	}


	private Course findCourseFromForm(AddCourseForm form) {
		for(Course c : form.getOwner().getCourses()){
			if(c.sameDay(form.getDate()) && c.getSlot() == form.getSlot()){
				return c;
			}
		}
		return null;
	}


	@Override
	public boolean courseIsAvailable(Course course) {
		return course.getCustomer() == null ? true : false;
	}


	@Override
	public Course getCourseById(long courseId) {
		return courseDao.findOne(courseId);
	}


	@Override
	public Course settleCourseFromApplication(Application app) {
		Course course = app.getCourse();
		if(course.getOwner() ==  app.getMaster() && course.getCustomer() == null){
			course.setCustomer(app.getSlave());
			course.setAvailable(false);
		}		
		return courseDao.save(course);
	}


}
