package org.sample.controller.pojos;

import javax.validation.constraints.Size;

import org.sample.model.Competence;

public class EditCompetenceForm {

	@Size(min=1, message="Cannot be blank")
	private String description;
	
	private Long compReferenceId;
	
	private Availability [][] availabilityBoard = new Availability[size][size];
	
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
		this.availabilityBoard = new Availability[5][5];
		for(int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				this.availabilityBoard[i][j] = new Availability();
			}
		}
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

	public Availability [][] getAvailabilityBoard() {
		return availabilityBoard;
	}

	public void setAvailabilityBoard(Availability [][] availabilityBoard) {
		this.availabilityBoard = availabilityBoard;
	}

}
