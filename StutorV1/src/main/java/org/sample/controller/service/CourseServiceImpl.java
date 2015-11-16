package org.sample.controller.service;

import java.util.Calendar;

import org.sample.model.Course;
import org.sample.model.Week;
import org.sample.model.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired 
	CalendarService calService;
	
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
				week.addCourse(course);
			}
		}
		return week;
	}

}
