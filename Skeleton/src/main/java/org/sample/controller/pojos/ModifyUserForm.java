package org.sample.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class ModifyUserForm{
	
	private long id;
	
	@Size(min=1)
	@NotNull
    private String firstName;
	
	@Size(min=1)
	@NotNull
    private String lastName;
    private String password;
    private String passwordControll;
    
    private boolean enableTutor;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordControll() {
		return passwordControll;
	}

	public void setPasswordControll(String passwordControll) {
		this.passwordControll = passwordControll;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getEnableTutor() {
		return enableTutor;
	}

	public void setEnableTutor(boolean enableTutor) {
		this.enableTutor = enableTutor;
	}
}
