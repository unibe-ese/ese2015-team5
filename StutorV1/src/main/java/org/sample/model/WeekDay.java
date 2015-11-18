package org.sample.model;

import java.util.Date;
import java.util.List;

public class WeekDay {

	private Date date;
	
	private List<Course> courses;

	public WeekDay(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
