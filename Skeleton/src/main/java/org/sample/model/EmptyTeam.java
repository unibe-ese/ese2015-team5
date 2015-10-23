package org.sample.model;

public class EmptyTeam implements TeamInterface{

	public String getName() {
		return "No Team";
	}

	public void setName(String name) {
		
	}

	public long getCreationDateInMilisec() {
		return 0;
	}

	public void setCreationDateInMilisec(long creationDateInMilisec) {
		
	}

	public long getId() {
		return 0;
	}

}
