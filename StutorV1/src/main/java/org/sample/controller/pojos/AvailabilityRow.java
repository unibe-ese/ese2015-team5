package org.sample.controller.pojos;

public class AvailabilityRow {

	private Availability[] availabilities;
	
	public AvailabilityRow(int size) {
		this.availabilities = new Availability[size];
		for(int i = 0; i < size; i++){
			this.availabilities[i]= new Availability();
		}
	}

	public Availability[] getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(Availability[] availabilities) {
		this.availabilities = availabilities;
	}

}
