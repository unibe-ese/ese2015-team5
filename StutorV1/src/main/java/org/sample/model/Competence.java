package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 * Represents a course that a {@link User} might offer as a tutor course. 
 * Contains a boolean value isEnabled, which indicates, if the owner is an enabled Tutor
 * at the moment. 
 * 
 * @field isEnabled: If the owner is offering tutoring at the moment.
 * @field description: A short description of the course.
 * @field owner: The {@link User}, who is offering the course.
 * 
 * @author ESE Team5
 *
 */

@Entity
public class Competence {

	@Id
    @GeneratedValue
	private long id;
	
	private boolean isEnabled;
	
	@ManyToOne
	private User owner;
	@Size(min=1)
	private String description;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String toString(){
		return "Description: " + this.description + ", Owner: " + owner.getEmail();
	}
	public boolean getisEnabled() {
		return isEnabled;
	}
	public void setisEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Competence other = (Competence) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
