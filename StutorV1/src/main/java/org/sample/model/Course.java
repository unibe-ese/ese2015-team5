package org.sample.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course implements CourseInterface{

	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private User owner;
	
	private long customerId;
	
	private Date date;
	
	private int slot;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
		return "occupied";
	}
	
	
	
}