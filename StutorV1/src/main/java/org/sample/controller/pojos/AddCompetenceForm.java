package org.sample.controller.pojos;

import javax.validation.constraints.Size;

/**
 * Holds information to create a {@link org.sample.model.Competence} Object and add it to a {@link org.sample.model.User}.
 * 
 * Is used to get information from the HTML file into the a Java Controller handily.
 * 
 * @author ESE Team5
 *
 */

public class AddCompetenceForm {
	
	@Size(min=1, message="Cannot be empty")
	private String description;
	
	private long ownerId;

	public AddCompetenceForm(){
		
	}

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
