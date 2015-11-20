package org.sample.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekDay {

	private Date date;
	
	private List<Course> courses;

	public WeekDay(Date date) {
		this.date = date;
		this.courses = new ArrayList<Course>();
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
	
	public void addCourse(Course course){
		this.courses.add(course);
	}

	public boolean sameDay(Date courseDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayYear = cal.get(Calendar.YEAR);
		int dayOfYear1 = cal.get(Calendar.DAY_OF_YEAR);
		
		cal.setTime(courseDate);
		int courseYear = cal.get(Calendar.YEAR);
		int dayOfYear2 = cal.get(Calendar.DAY_OF_YEAR);
		
		return (dayYear == courseYear) && (dayOfYear1 == dayOfYear2);
	}
	
}
