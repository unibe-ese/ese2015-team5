package org.sample.controller.pojos;

import javax.validation.constraints.Size;

import org.sample.model.Competence;

public class EditCompetenceForm {

	@Size(min=1, message="Cannot be blank")
	private String description;
	
	private Long compReferenceId;
	
	private AvailabilityRow [] availabilityRows;
	
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
		this.availabilityRows = new AvailabilityRow[size];
		for(int i = 0; i < size; i++){
			this.availabilityRows[i]= new AvailabilityRow(size);
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

	public AvailabilityRow[] getAvailabilityRows() {
		return availabilityRows;
	}

	public void setAvailabilityRows(AvailabilityRow[] availabilityRows) {
		this.availabilityRows = availabilityRows;
	}
	
	

}
