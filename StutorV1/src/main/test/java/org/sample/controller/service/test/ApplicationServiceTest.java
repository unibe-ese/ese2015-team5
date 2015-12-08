package org.sample.controller.service.test; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.sample.controller.pojos.ApplicationForm;
import org.sample.controller.service.ApplicationService;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.User;
import org.sample.model.dao.ApplicationDao;
import org.sample.model.dao.CourseDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class ApplicationServiceTest<tutorApplications> {

	@Autowired 
	ApplicationDao appDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ApplicationService appService;
	
	@Autowired
	UserDao userDao;
	
	private Course course, settledCourse, pastCourse, futureCourse;
	
	private User user1, user2;
	
	private ApplicationForm appForm;
	
	private Application expectedApplication, applicationToAccept,
		pastTutorApplication, futureTutorApplication, 
		pastStudentApplication, futureStudentApplication;
	
	private List<Application> tutorApplications, studentApplications;
	
	@Before
	public void setup(){
		
		user1 = new User();
		user2 = new User();
		
		course = new Course();
		course.setOwner(user1);
		course.setAvailable(true);
		course.setId(1);
		
		settledCourse= new Course();
		settledCourse.setOwner(user1);
		settledCourse.setAvailable(false);
		settledCourse.setCustomer(user2);
		
		appForm = new ApplicationForm();
		appForm.setCourse(course);
		appForm.setApplicant(user2);
		
		applicationToAccept = new Application();
		applicationToAccept.setCourse(course);
		applicationToAccept.setStudent(user2);
		applicationToAccept.setTutor(user1);
		
		expectedApplication = new Application();
		expectedApplication.setCourse(course);
		expectedApplication.setStudent(user2);
		expectedApplication.setTutor(user1);
		
		List<Application> apps = new ArrayList<Application>();
		apps.add(expectedApplication);
		user1.setMyTutorApplications(apps);
		user2.setMyApplications(apps);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		pastCourse = new Course();
		pastCourse.setDate(cal.getTime());
		pastCourse.setId(-5);
		
		cal.add(Calendar.DAY_OF_YEAR, 2);
		futureCourse = new Course();
		futureCourse.setDate(cal.getTime());
		futureCourse.setId(5);
		
		pastTutorApplication = new Application();
		pastTutorApplication.setCourse(pastCourse);
		
		futureTutorApplication  = new Application();
		futureTutorApplication.setCourse(futureCourse);
			
		tutorApplications = new ArrayList<Application>();
		
		tutorApplications.add(pastTutorApplication);
		tutorApplications.add(futureTutorApplication);
		
		pastStudentApplication = new Application();
		pastStudentApplication.setCourse(pastCourse);
		
		futureStudentApplication = new Application();
		futureStudentApplication.setCourse(futureCourse);
		
		studentApplications = new ArrayList<Application>();
		
		studentApplications.add(pastStudentApplication);
		studentApplications.add(futureStudentApplication);
		
		Mockito.when(appDao.save(any(Application.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(courseDao.save(any(Course.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(userDao.findOne(any(long.class))).thenReturn(user1);
	}
	
	@Test
	public void saveApplicationSuccessTest(){
		Application application = appService.saveApplication(appForm);
		assertEquals(expectedApplication, application);
	}
	
	@Test
	public void deleteApplicationTest(){
		appService.deleteApplication(expectedApplication);
		assertEquals(0, user1.getMyTutorApplications().size());
		assertEquals(0, user2.getMyApplications().size());
	}
	
	@Test
	public void deleteApplicationNullUserTest(){
		expectedApplication.setStudent(null);
		appService.deleteApplication(expectedApplication);
		assertEquals(0, user1.getMyTutorApplications().size());
		assertEquals(0, user2.getMyApplications().size());
	}
	
	@Test
	public void deleteApplicationNullUserTest2(){
		expectedApplication.setTutor(null);
		appService.deleteApplication(expectedApplication);
		assertEquals(0, user1.getMyTutorApplications().size());
		assertEquals(0, user2.getMyApplications().size());
	}
	
	@Test
	public void acceptApplicationTest(){
		Course course2 = applicationToAccept.getCourse();
		assertTrue(course2.isAvailable());
		assertEquals(null, course2.getCustomer());
		Course retournedCourse = appService.acceptApplication(applicationToAccept);
		assertEquals(course2, retournedCourse);
		assertFalse(retournedCourse.isAvailable());
	
	}

//	@Test
//	public void getFutureApplicationsTest(){
//		user1.setMyApplications(studentApplications);
//		user1.setMyTutorApplications(tutorApplications);
//		List<Application> apps = appService.getFutureApplications();
//		System.out.println(apps.toString());
//	}
	
	@Test
	public void notDuplicateTest(){
		user2.setMyApplications(studentApplications);
		assertTrue(appService.notDuplicate(appForm));
		
		studentApplications.add(expectedApplication);
		user2.setMyApplications(studentApplications);
		
		assertFalse(appService.notDuplicate(appForm));
		
	}
	
}
