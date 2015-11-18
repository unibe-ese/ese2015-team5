package org.sample.model;

import java.util.Calendar;
import java.util.List;

public class WeekDay {

	private Calendar date;
	
	private List<Course> courses;

	public WeekDay(Calendar instance) {
		this.date = instance;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
