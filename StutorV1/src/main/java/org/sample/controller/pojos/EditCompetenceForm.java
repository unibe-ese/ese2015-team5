package org.sample.controller.pojos;

import javax.validation.constraints.Size;

import org.sample.model.Competence;

public class EditCompetenceForm {

	@Size(min=1, message="Cannot be blank")
	private String description;
	
	private Long compReferenceId;
	
	private Boolean[] availability = new Boolean[5];
	
	private static int size = 5;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		EditCompetenceForm.size = size;
	}

	public EditCompetenceForm(){
		
	}
	
	public EditCompetenceForm(Competence comp){
		this.description = comp.getDescription();
		this.compReferenceId = comp.getId();

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getCompReferenceId(){
		return this.compReferenceId;
	}
	
	public void setCompReferenceId(Long id){
		this.compReferenceId = id;
	}
	
	public String toString(){
		return "Desc: " + this.description + ", ID: " + this.compReferenceId;
	}
//
//	public boolean isAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(boolean availability) {
//		this.availability = availability;
//	}

	public Boolean[] getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean[] availability) {
		this.availability = availability;
	}
	
	


}
