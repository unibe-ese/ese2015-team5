package org.sample.controller.pojos;

import org.sample.model.User;

public class AddCourseForm {
	
	private int slot;
	
	private String date;
	
	private User owner;
	

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
