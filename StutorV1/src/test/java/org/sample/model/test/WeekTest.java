package org.sample.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.sample.model.Week;

public class WeekTest {
	
	private Calendar instance = Calendar.getInstance();
	private Week week;
	
	@Before
	public void setup(){
		this.instance = Calendar.getInstance();
		week = Week.buildWeek(instance);
	}

	@Test
	public void buildWeekTest(){		
		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
		for(int i = 0; i < Week.WEEKDAYS; i++){
			assertEquals(instance.getTime(), week.getWeekDays()[i].getDate());
			
			instance.add(Calendar.DAY_OF_WEEK, 1);		
		}			
	}
	
	@Test
	public void isDuringTest(){
		instance.setTime(week.getWeekDays()[0].getDate());
		assertTrue(week.isDuring(instance.getTime()));
		instance.add(Calendar.DAY_OF_YEAR, -1);
		assertFalse(week.isDuring(instance.getTime()));
		instance.add(Calendar.DAY_OF_YEAR, 6);
		assertTrue(week.isDuring(instance.getTime()));
		instance.add(Calendar.DAY_OF_YEAR, 1);
		assertFalse(week.isDuring(instance.getTime()));
		
	}
}
