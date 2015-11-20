package org.sample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekDay {

	private static final String[] NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	public static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	private Date date;
	
	private String dateString;
	
	private String name;
	
	private List<CourseInterface> courses;
	
	public WeekDay(Date date) {
		this.date = date;
		this.setDateString(FORMAT.format(date));
		setupName();
		setupCourses();
	}

	private void setupCourses() {
		this.courses = new ArrayList<CourseInterface>();
		for(int i = 0; i < 24; i++){
			EmptyCourse course = new EmptyCourse();
			course.setSlot(i);
			courses.add(course);
			
		}
	}

	private void setupName() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		this.name = NAMES[dayOfWeek - 1];
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean sameDay(Date courseDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayYear = cal.get(Calendar.YEAR);
		int dayOfYear1 = cal.get(Calendar.DAY_OF_YEAR);
		
		cal.setTime(courseDate);
		int courseYear = cal.get(Calendar.YEAR);
		int dayOfYear2 = cal.get(Calendar.DAY_OF_YEAR);
		
		return (dayYear == courseYear) && (dayOfYear1 == dayOfYear2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
	
	}

	public List<CourseInterface> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseInterface> courses) {
		this.courses = courses;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public void addCourse(Course course) {
		this.courses.add(course.getSlot(), course);
		
	}
	
	
	//TODO: name
	
}
