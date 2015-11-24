package org.sample.model;

public interface CourseInterface {

	public long getId();
	
	public int getSlot();
	
	public void setSlot(int slot);
	
	public String getDescription();
	
	public boolean isAvailable();
}

