package org.sample.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Week {

	private Calendar startOfWeek, endOfWeek;
	
	private List<Course> coursesDuringTheWeek;
	
	public void setStartOfWeek(Calendar instance) {
		this.startOfWeek = instance;
		
	}

	public void setEndOfWeek(Calendar instance) {
		this.endOfWeek = instance;
		
	}

	public static Week buildWeek(Calendar instance) {
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		Week week = new Week();
		week.setStartOfWeek(instance);
		instance.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		week.setEndOfWeek(instance);
		return week;
	}

	public Calendar getStartOfWeek() {
		return startOfWeek;
	}

	public Calendar getEndOfWeek() {
		return endOfWeek;
	}

	public void addCourse(Course course) {
		if(this.coursesDuringTheWeek == null){
			this.coursesDuringTheWeek = new ArrayList<Course>();
		}
		this.coursesDuringTheWeek.add(course);
		
	}

}
