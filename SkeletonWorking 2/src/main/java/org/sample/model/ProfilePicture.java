package org.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A profile picture for a {@link User}.
 * 
 * @author Ese Team5
 *
 */

@Entity
public class ProfilePicture {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "LONGBLOB") 
	private byte[] file;

	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] bs) {
		this.file = bs;
	}


}
