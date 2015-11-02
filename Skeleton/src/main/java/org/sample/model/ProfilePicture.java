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
	
	@Column(columnDefinition = "LONGBLOB") 
	private byte[] file;
	
	private String name;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
