package org.sample.controller.pojos;

import javax.validation.constraints.Size;


public class AddCompetenceForm {

	@Size(min=1, max=20)
	private String description;
	
	private long ownerId;



	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
