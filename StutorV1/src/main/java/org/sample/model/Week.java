package org.sample.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Week {

	public final static int WEEKDAYS = 6;
	
	private WeekDay[] weekDays;
	
	private List<Course> coursesDuringTheWeek;
	
	public void setStartOfWeek(Date date) {
		this.weekDays = new WeekDay[WEEKDAYS];
		this.weekDays[0] = new WeekDay(date);
		
	}
	
	public boolean isDuring(Date date){
		if(date.after(weekDays[0].getDate()) && date.before(weekDays[WEEKDAYS].getDate())){
			return true;
		}
		return false;
	}


	public static Week buildWeek(Calendar instance) {
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		Week week = new Week();
		week.weekDays = new WeekDay[WEEKDAYS];
		for(int j = 0; j < WEEKDAYS; j++){			
			week.weekDays[j] = new WeekDay(instance.getTime());
			instance.add(Calendar.DAY_OF_YEAR, 1);
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
