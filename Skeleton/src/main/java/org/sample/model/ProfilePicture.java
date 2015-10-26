package org.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ProfilePicture {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "BLOB") 
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
