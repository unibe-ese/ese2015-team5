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
