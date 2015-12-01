package org.sample.model;

import java.util.Calendar;

/**
 * Represents a empty or available/unavailable Course. 
 * Simplifies {@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
 * 
 * @author hess
 *
 */
public interface CourseInterface {

	public long getId();
	
	public int getSlot();
	
	public void setSlot(int slot);
	
	public String getDescription();
	
	public boolean isAvailable();
	
}

