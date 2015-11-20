package org.sample.model;

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
		return "free";
	}

}
