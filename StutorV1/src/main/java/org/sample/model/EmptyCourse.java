package org.sample.model;

import java.util.Calendar;

/**
 * Represents a empty Course.
 * see{@link org.sample.controller.service.CourseServiceImpl#buildCalendar(Calendar cal, User user) buildCalendar(Calendar cal, User user)}.
 * 
 * @author hess
 *
 */
public class EmptyCourse implements CourseInterface {

	private int slot;
	
	@Override
	public int getSlot() {
		return slot;
	}

	@Override
	public void setSlot(int slot) {
		this.slot = slot;
		
	}

	@Override
	public String getDescription() {
		return "X";
	}

	@Override
	public boolean isAvailable() {
		return false;
	}

	@Override
	public long getId() {
		return -1;
	}

}
