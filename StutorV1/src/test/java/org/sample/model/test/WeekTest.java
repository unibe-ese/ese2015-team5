package org.sample.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.sample.model.Course;
import org.sample.model.Week;

public class WeekTest {
	
	private Date initialDate, monday, lastSunday, nextMonday, sunday;
	private Calendar instance = Calendar.getInstance();
	private Week week;
	private Course course;
	
	@Before
	public void setup(){
		this.instance = Calendar.getInstance();
		initialDate = instance.getTime();
		
		instance.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		monday = instance.getTime();
		
		instance.add(Calendar.DAY_OF_YEAR, -1);
		lastSunday = instance.getTime();
		
		instance.add(Calendar.DAY_OF_YEAR, 8);
		nextMonday = instance.getTime();
		
		instance.add(Calendar.DAY_OF_YEAR, -1);
		sunday = instance.getTime();
		
		instance.setTime(initialDate);
		
		course = new Course();
		
		week = Week.buildWeek(instance);
	}

	@Test
	public void buildWeekTest(){		
		instance.setTime(initialDate);
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		for(int i = 0; i < Week.WEEKDAYS; i++){
			assertEquals(instance.getTime(), week.getWeekDays()[i].getDate());
			
			instance.add(Calendar.DAY_OF_WEEK, 1);			
		}			
	}
	
	@Test
	public void isDuringTest(){
		
		course.setDate(initialDate);
		assertTrue(course.isDuring(week));
		
		course.setDate(monday);
		assertTrue(course.isDuring(week));
		
		course.setDate(sunday);
		assertTrue(course.isDuring(week));
		
	}
	
	@Test
	public void isNotDuringTest(){
		course.setDate(lastSunday);		
		assertFalse(course.isDuring(week));
				
		course.setDate(nextMonday);		
		assertFalse(course.isDuring(week));
	}
}
