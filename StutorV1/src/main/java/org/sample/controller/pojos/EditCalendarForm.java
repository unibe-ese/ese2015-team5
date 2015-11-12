package org.sample.controller.pojos;

import javax.persistence.OneToOne;

import org.sample.model.Competence;

public class EditCalendarForm {
	
	@OneToOne
	private Competence comp;
	
	private boolean [][] availabilityBoard = new boolean[5][5];

	public Competence getComp() {
		return comp;
	}

	public void setComp(Competence comp) {
		this.comp = comp;
	}

	public boolean [][] getAvailabilityBoard() {
		return availabilityBoard;
	}

	public void setAvailabilityBoard(boolean [][] availabilityBoard) {
		this.availabilityBoard = availabilityBoard;
	}
	
	public boolean getAvailabilityToken(int i, int j){
		return availabilityBoard[i][j];
	}
	
	public void setAvailabilityToken(int i, int j, boolean bool){
		availabilityBoard[i][j] = bool;
	}
	
	

}
