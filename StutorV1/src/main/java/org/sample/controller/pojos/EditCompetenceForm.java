package org.sample.controller.pojos;

import javax.validation.constraints.Size;

import org.sample.model.Competence;

public class EditCompetenceForm {

	@Size(min=1, message="Cannot be blank")
	private String description;
	
	private Long compReferenceId;
	
	private boolean [][] availabilityBoard = new boolean[5][5];
	
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

	public boolean [][] getAvailabilityBoard() {
		return availabilityBoard;
	}

	public void setAvailabilityBoard(boolean [][] availabilityBoard) {
		this.availabilityBoard = availabilityBoard;
	}

}
