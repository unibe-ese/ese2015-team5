package org.sample.controller.service;

import java.text.ParseException;
import java.util.Calendar;

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
	
	@Override
	public Week buildCalendar(Calendar instance) {
		Week week = Week.buildWeek(instance);
		return findAllForWeek(week);
		
	}

	private Week findAllForWeek(Week week) {
		for(Course course : courseDao.findAll()){
			if(course.isDuring(week)){
//				week.addCourse(course);
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
