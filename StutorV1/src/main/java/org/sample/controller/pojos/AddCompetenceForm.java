package org.sample.controller.pojos;


/**
 * Holds information to create a {@link org.sample.model.Competence} Object and add it to a {@link org.sample.model.User}.
 * 
 * Is used to get information from the HTML file into the a Java Controller handily.
 * 
 * @author ESE Team5
 *
 */

public class AddCompetenceForm {
	
	private String description;
	
	private String grade;
	
	private Long ownerId;

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	
	
	
}
