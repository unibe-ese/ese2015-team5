package org.sample.controller.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.controller.service.CourseService;
import org.sample.model.Course;
import org.sample.model.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class CourseServiceTest {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseDao courseDao;
	
	Calendar cal;
	
	private List<Course> courses;
	private Course course1, course2, course3;
	
	@Before
	public void setup(){
		cal = Calendar.getInstance();
		course1 = new Course();
		course2 = new Course();
		course3 = new Course();
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		course1.setDate(cal.getTime());
		cal.add(Calendar.DAY_OF_YEAR, -1);
		course2.setDate(cal.getTime());
		cal.add(Calendar.DAY_OF_YEAR, 7);
		course3.setDate(cal.getTime());
		courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		when(courseDao.findAll()).thenReturn(courses);
	}
	
	@Test
	public void initializeTest(){
		assertNotNull(courseService);
		assertNotNull(courseDao);
	}
	
//	@Test
//	public void buildWeekTest(){
//		Week week = courseService.buildCalendar(Calendar.getInstance());
//		assertEquals(1, week.getWeekDays()[0].getCourses().size());
//		assertEquals(course1, week.getWeekDays()[0].getCourses().get(0));
//		for(int i = 1; i < Week.WEEKDAYS; i++){
//			assertEquals(0, week.getWeekDays()[i].getCourses().size());
//		}
//	}

}
