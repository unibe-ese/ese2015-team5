package org.sample.controller.pojos;

import java.util.Date;

import org.sample.model.User;

public class AddCourseForm {
	
	private int slot;
	
	private String dateString;
	
	private User owner;
	
	private Date date;

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String date) {
		this.dateString = date;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
