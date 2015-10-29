package org.sample.controller.pojos;

import org.hibernate.validator.constraints.NotBlank;


public class AddCompetenceForm {

	@NotBlank(message = "Please provide your firstname")
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
