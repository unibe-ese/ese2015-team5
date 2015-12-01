package org.sample.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Contains {@link Course}'s and {@link Date} for one Week for a {@link User}.
 * Consists of 7 {@link WeekDays}.
 * 
 * Is only built with {@link #buildWeek(Calendar instance)}.
 * 
 * @field: weekDays: The 7 {@link WeekDay}s
 * @field: WEEKDAYS: A constant, for how many days there are in a week.
 * 
 * @author ESE Team5
 *
 */
public class Week {

	public final static int WEEKDAYS = 7;
	
	private WeekDay[] weekDays;
	
	public void setStartOfWeek(Date date) {
		this.weekDays = new WeekDay[WEEKDAYS];
		this.weekDays[0] = new WeekDay(date);
		
	}
	
	/**
	 * Calculates, if a {@link Date} is during a {@link Week}.
	 * Returns true if yes, false if its not during the week.
	 * 
	 * @param date
	 */
	public boolean isDuring(Date date){
		Date monday = weekDays[0].getDate();
		Date sunday = weekDays[WEEKDAYS - 1].getDate();
		return date.compareTo(sunday) <= 0 && 0 <= date.compareTo(monday);
	}

	/**
	 * Builds a {@link Week} for a Calendar instance.
	 * Initializes all the {@link Weekday}s and sets the correct Dates for these.
	 * 
	 * @param instance
	 * @return a new Week for the instance.
	 */
	public static Week buildWeek(Calendar instance) {
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		Week week = new Week();		
		week.initializeDays(instance);	
		return week;
	}

	/**
	 * Sets all the dates for the {@link Weekday}s.
	 * 
	 */
	private void initializeDays(Calendar instance) {
		this.weekDays = new WeekDay[WEEKDAYS];
		for(int j = 0; j < WEEKDAYS; j++){		
			WeekDay day = new WeekDay(instance.getTime());
			this.weekDays[j] = day;
			instance.add(Calendar.DAY_OF_YEAR, 1);
		}
	}


	public WeekDay[] getWeekDays() {
		return weekDays;
	}
}
