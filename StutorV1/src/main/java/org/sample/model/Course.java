package org.sample.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Represents a time, when a {@link User} has time to tutor.
 * Another user can send an {@link org.sample.model.Application Application} for a course.
 * Customer being null means that the course is still available.
 * Costumer being a user means that the course is booked.
 * The date and slot help locate it exactly in a {@link org.sample.model.Week Week}
 * 
 * Implements {@link CourseInterace}, to simplify the 
 * {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
 * 
 * @field: Owner: The user that offers tutoring
 * @field: Customer: The user that requests tutoring.
 * @field: date: The date, when the the course is.
 * @field: slot: Represents the daytime.
 * @field: available: Represents if the course is already booked. 
 * 
 * @author hess
 *
 */

@Entity
public class Course implements CourseInterface{

	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private User owner;
	@OneToOne
	private User customer;
	
	private Date date;
	
	private int slot;
	
	private boolean available;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Calculates, if a certain Course is during a {@link org.sample.model.Week}.
	 * Only cares about the date, hours/minutes/seconds are ignored.
	 * 
	 * @param week
	 * @return if this is during the week.
	 */
	public boolean isDuring(Week week){
		Date monday = week.getWeekDays()[0].getDate();
		Date sunday = week.getWeekDays()[6].getDate();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(monday);
		int startDay = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(sunday);
		int endDay = cal.get(Calendar.DAY_OF_YEAR);
		int year = cal.get(Calendar.YEAR);
		
		cal.setTime(this.date);
		int courseDay = cal.get(Calendar.DAY_OF_YEAR);
		return year == cal.get(Calendar.YEAR) && startDay <= courseDay && courseDay <= endDay;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String getDescription() {
		return available ? "free" : "booked";
	}

	/**
	 * Calculates if a Course is on a certain {@link Date}.
	 * 
	 * @param date2
	 * @return boolean, if Course is during week.
	 */
	public boolean sameDay(Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int courseYear = cal.get(Calendar.YEAR);
		int courseDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(date2);
		int compareYear = cal.get(Calendar.YEAR);
		int compareDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		return courseYear == compareYear && courseDayOfYear == compareDayOfYear;
	}

	@Override
	public boolean isAvailable() {
		return this.available;
	}
	
	public void setAvailable(boolean available){
		this.available = available;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	/**
	 * Calculates if a Course is in the past.
	 * 
	 * @return
	 */
	public boolean isInThePast() {
		Calendar cal = Calendar.getInstance();
		
		int compareYear = cal.get(Calendar.YEAR);
		int compareDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		
		cal.setTime(this.date);
		int courseYear = cal.get(Calendar.YEAR);
		int courseDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		
		return courseYear < compareYear || (courseYear == compareYear && courseDayOfYear < compareDayOfYear);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
