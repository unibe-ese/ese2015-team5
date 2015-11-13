package org.sample.controller.pojos;

public class Availability {

	private boolean available;
	private int value = 0;
	
	public void setAvailable(boolean available){
		this.available = available;
	}
	
	public boolean getAvailable(){
		return this.available;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
