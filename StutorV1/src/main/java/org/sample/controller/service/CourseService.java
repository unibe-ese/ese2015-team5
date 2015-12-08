package org.sample.controller.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.sample.controller.exceptions.InvalidCourseDateException;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.Week;

public interface CourseService {

	Week buildCalendar(Calendar instance, User user);
	
	Week buildCalendar(Date date, User user);

	Course save(AddCourseForm form) throws ParseException, InvalidCourseDateException;

	Object buildCalendar(Date date);

	Week buildCalendar(Calendar cal);

	boolean alreadyExists(AddCourseForm form);

	void deleteCourse(AddCourseForm form);

	boolean courseIsAvailable(Course course);

	Course getCourseById(long courseId);

	Course settleCourseFromApplication(Application app);

	Collection<Course> findStudenCoursesFor(User user);
	
	void deleteCourse(Course course);

}
