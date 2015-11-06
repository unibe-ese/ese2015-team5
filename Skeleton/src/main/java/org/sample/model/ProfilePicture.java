package org.sample.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.sample.controller.exceptions.InvalidUserException;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class ProfilePicture {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "LONGBLOB") 
	private byte[] file;
	
	public ProfilePicture(){
	}
	
	public ProfilePicture(MultipartFile file) throws InvalidUserException{
		try {
			this.file = file.getBytes();
		} catch (IOException e) {
			throw new InvalidUserException("Picture could not be processed");
		}
	}

	
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
