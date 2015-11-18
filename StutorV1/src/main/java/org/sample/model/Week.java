package org.sample.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Week {

	public final static int WEEKDAYS = 6;
	
	private WeekDay[] weekDays;
	
	private List<Course> coursesDuringTheWeek;
	
	public void setStartOfWeek(Calendar instance) {
		this.weekDays = new WeekDay[WEEKDAYS];
		this.weekDays[0] = new WeekDay(instance);
		
	}


	public static Week buildWeek(Calendar instance) {
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		Week week = new Week();
		week.setStartOfWeek(instance);
		for(int j = 1; j < WEEKDAYS; j++){
			instance.add(Calendar.DATE, j);
			week.weekDays[j] = new WeekDay(instance);
			System.out.println(week.weekDays[j].getDate().getTime());
		}	
		return week;
	}



	public void addCourse(Course course) {
		if(this.coursesDuringTheWeek == null){
			this.coursesDuringTheWeek = new ArrayList<Course>();
		}
		this.coursesDuringTheWeek.add(course);
		
	}


	public WeekDay[] getWeekDays() {
		return weekDays;
	}
}
