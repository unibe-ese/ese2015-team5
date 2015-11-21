package org.sample.model;

import java.util.Calendar;
import java.util.Date;

public class Week {

	public final static int WEEKDAYS = 7;
	
	private WeekDay[] weekDays;
	
	public void setStartOfWeek(Date date) {
		this.weekDays = new WeekDay[WEEKDAYS];
		this.weekDays[0] = new WeekDay(date);
		
	}
	
	public boolean isDuring(Date date){
		Date monday = weekDays[0].getDate();
		Date sunday = weekDays[WEEKDAYS - 1].getDate();
		System.out.println("Sunday: " + date.compareTo(sunday));
		System.out.println("Monday: " + date.compareTo(monday));
		return date.compareTo(sunday) <= 0 && 0 <= date.compareTo(monday);
	}

	public static Week buildWeek(Calendar instance) {
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		Week week = new Week();		
		week.initializeDays(instance);	
		return week;
	}

	private void initializeDays(Calendar instance) {
		this.weekDays = new WeekDay[WEEKDAYS];
		for(int j = 0; j < WEEKDAYS; j++){		
			WeekDay day = new WeekDay(instance.getTime());
			this.weekDays[j] = day;
			instance.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
//
//	public void addCourse(Course course) {
//		for(int i = 0; i < WEEKDAYS; i++){
//			if(weekDays[i].sameDay(course.getDate())){
//				weekDays[i].addCourse(course);
//			}
//		}
//		
//	}


	public WeekDay[] getWeekDays() {
		return weekDays;
	}
}
