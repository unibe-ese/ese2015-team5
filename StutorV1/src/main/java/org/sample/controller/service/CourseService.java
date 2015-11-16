package org.sample.controller.service;

import java.util.Calendar;

import org.sample.model.Week;

public interface CourseService {

	Week buildCalendar(Calendar instance);

}
