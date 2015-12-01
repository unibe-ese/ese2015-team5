package org.sample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents a Day in a {@link Week}.
 * 
 * Contans a list of {@link CourseInterface}s with size. This consists of all the real courses for the Date of the 
 * Day, filled up with {@link EmptyCourse}s.
 * 
 * @field date: a {@link Date} when the Day is.
 * @field dateString: A String representation for the Date
 * @field name: The name of the Day. (e.g. Monday)
 * @field courses: The list of courses for this day.
 * 
 * @author hess
 *
 */

public class WeekDay {

	private static final String[] NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	public static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	private Date date;
	
	private String dateString;
	
	private String name;
	
	private CourseInterface[] courses;
	
	public WeekDay(Date date) {
		this.date = date;
		this.setDateString(FORMAT.format(date));
		setupName();
		setupCourses();
	}

	/**
	 * Initializes the list courses with a ArrayList.
	 * Size 24, filled with {@link EmptyCourse}s.
	 * 
	 */
	private void setupCourses() {
		this.courses = new CourseInterface[24];
		for(int i = 0; i < 24; i++){
			EmptyCourse course = new EmptyCourse();
			course.setSlot(i);
			courses[i] = course;
			
		}
	}

	/**
	 * Selects the correct dayname (e.g. Monday) for a Date.
	 */
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

	/**
	 * Calculates if the date of this Day is the same Date as another.
	 * Ignores hours, minutes, seconds.
	 * 
	 * @param courseDate: The date to compare.
	 * @return: Same date or not.
	 */
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

	public CourseInterface[] getCourses() {
		return courses;
	}

	public void setCourses(CourseInterface[] courses) {
		this.courses = courses;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public void addCourse(Course course) {
		this.courses[course.getSlot()] = course;
		
	}
	
}
