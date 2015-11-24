package org.sample.model.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.sample.model.Course;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseTest {
	
	private Course course;
	private Date oneYearLater, oneYearAndADayLater, oneDayLater, sameDayYear;
	
	@Before
	public void setup(){
		course = new Course();
		Calendar cal = Calendar.getInstance();
		course.setDate(cal.getTime());
		sameDayYear = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		oneYearLater = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		oneYearAndADayLater = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		oneDayLater = cal.getTime();		
	}
	
	@Test
	public void sameDayTest(){
		assertTrue(course.sameDay(sameDayYear));
		assertFalse(course.sameDay(oneYearLater));
		assertFalse(course.sameDay(oneYearAndADayLater));
		assertFalse(course.sameDay(oneDayLater));
	}

}
