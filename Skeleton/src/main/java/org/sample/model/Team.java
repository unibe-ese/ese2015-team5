package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team implements TeamInterface {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private long creationDateInMilisec;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCreationDateInMilisec() {
		return creationDateInMilisec;
	}
	public void setCreationDateInMilisec(long creationDateInMilisec) {
		this.creationDateInMilisec = creationDateInMilisec;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (int) (creationDateInMilisec ^ (creationDateInMilisec >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (creationDateInMilisec != other.creationDateInMilisec)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	
	
}
