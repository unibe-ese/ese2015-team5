package org.sample.controller.service.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.sample.controller.pojos.AddCourseForm;
import org.sample.controller.pojos.ApplicationForm;
import org.sample.controller.service.CourseService;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.User;
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
	
	private Course course1, course2, course3, expectedCourse;
	
	private Date futureDate, pastDate, dateNotInList;
	
	private AddCourseForm form;
	
	private User user, applier;
	
	Application application;
	
	@Captor
	private ArgumentCaptor<Course> captor;
	
	@Before
	public void setup(){
		
		captor = ArgumentCaptor.forClass(Course.class);
		
		cal = Calendar.getInstance();
		course1 = new Course();
		course2 = new Course();
		course3 = new Course();
		
		//Monday
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		course1.setDate(cal.getTime());
		
		//Last Sunday
		cal.add(Calendar.DAY_OF_YEAR, -1);
		pastDate = cal.getTime();
		course2.setDate(pastDate);
		
		//This Sunday
		cal.add(Calendar.DAY_OF_YEAR, 7);
		futureDate = cal.getTime();		
		course3.setDate(futureDate);
		
		cal.add(Calendar.DAY_OF_YEAR, 10);
		dateNotInList = cal.getTime();
		
		courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		form = new AddCourseForm();
		form.setDate(futureDate);
		user = new User();
		user.setEmail("blubbi");
		form.setOwner(user);
		form.setSlot(1);
		
		expectedCourse = new Course();
		expectedCourse.setOwner(user);
		expectedCourse.setDate(futureDate);
		
		user.setCourses(courses);
		
		applier = new User();
		application = new Application();
		application.setSlave(applier);
		application.setCourse(expectedCourse);
		application.setMaster(user);
		
		when(courseDao.save(captor.capture())).thenReturn(null);
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
	
	@Test
	public void saveTest() throws ParseException{
		courseService.save(form);
		assertEquals(expectedCourse, captor.getValue());
		form.setDate(pastDate);
		Course course = courseService.save(form);
		assertEquals(null, course);
		form.setOwner(null);
		course = courseService.save(form);
		assertEquals(null, course);
	}

	@Test
	public void alreadyExistsTest(){
		assertFalse(courseService.alreadyExists(form));
		form.setSlot(0);
		assertTrue(courseService.alreadyExists(form));
		form.setDate(dateNotInList);
		assertFalse(courseService.alreadyExists(form));
		form.setSlot(1);
		assertFalse(courseService.alreadyExists(form));
	}
	
	@Test
	public void courseIsAvailableTest(){
		assertTrue(courseService.courseIsAvailable(expectedCourse));
		expectedCourse.setCustomer(new User());
		assertFalse(courseService.courseIsAvailable(expectedCourse));
	}
	
	@Test
	public void settleCourseTest(){
		courseService.settleCourseFromApplication(application);
		assertEquals(applier, expectedCourse.getCustomer());
		courseService.settleCourseFromApplication(application);
		assertEquals(applier, expectedCourse.getCustomer());
	}
	
	@Test
	public void settleOccupiedCourseTest(){
		application.setMaster(new User());
		courseService.settleCourseFromApplication(application);
		assertEquals(null, expectedCourse.getCustomer() );
	}
}
