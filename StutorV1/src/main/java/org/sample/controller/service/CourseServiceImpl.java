package org.sample.controller.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.sample.controller.pojos.AddCourseForm;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.Week;
import org.sample.model.WeekDay;
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
	public Week buildCalendar(Calendar instance) {
		Week week = Week.buildWeek(instance);
		return findAllForWeek(week);
		
	}

	private Week findAllForWeek(Week week) {
		User user  = userService.getCurrentUser();
		List<Course> courses = user.getCourses();		
			for(Course course : courses){
				if(course.isDuring(week)){
					Calendar cal = Calendar.getInstance();
					cal.setTime(course.getDate());
					int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
					week.getWeekDays()[dayOfWeek-1].addCourse(course);
				}			
		}
		return week;
	}

	@Override
	public Course save(AddCourseForm form) throws ParseException {
		User user = form.getOwner();
		if(user != null){
			Course course = new Course();
			course.setOwner(user);
			course.setDate(WeekDay.FORMAT.parse(form.getDate()));
			course.setSlot(form.getSlot());
			return courseDao.save(course);
		}
		return null;
	}

}
