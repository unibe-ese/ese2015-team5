package org.sample.controller.service;

import java.text.ParseException;
import java.util.Calendar;

import org.sample.controller.pojos.AddCourseForm;
import org.sample.model.Course;
import org.sample.model.Week;

public interface CourseService {

	Week buildCalendar(Calendar instance);

	Course save(AddCourseForm form) throws ParseException;

}
