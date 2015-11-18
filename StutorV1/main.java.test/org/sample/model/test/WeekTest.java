package org.sample.model.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.Before;
import org.sample.model.Week;

public class WeekTest {
	
	private Calendar instance = Calendar.getInstance();
	private Week week;
	private Date beforeDate, duringDate1, duringDate2, afterDate;
	
	@Before
	public void setup(){
		this.instance = Calendar.getInstance();
		week = Week.buildWeek(instance);
//		instance.set(Calendar.DAY_OF_WEEK, instance.getFirstDayOfWeek());
//		System.out.println(instance.getTime());
//		duringDate1 = instance.getTime();
//		instance.add(Calendar.DAY_OF_YEAR, -1);
//		System.out.println(instance.getTime());
//		beforeDate = instance.getTime();
//		instance.add(Calendar.DAY_OF_YEAR, 8);
//		System.out.println(instance.getTime());
//		duringDate2 = instance.getTime();
//		instance.add(Calendar.DAY_OF_YEAR, 1);
//		System.out.println(instance.getTime());
//		afterDate = instance.getTime();
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
//		assertTrue(week.isDuring(duringDate1));
//		assertTrue(week.isDuring(duringDate2));
//		assertFalse(week.isDuring(beforeDate));
//		assertFalse(week.isDuring(afterDate));
	}
}
