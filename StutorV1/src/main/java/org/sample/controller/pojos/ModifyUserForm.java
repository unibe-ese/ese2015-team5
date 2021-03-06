package org.sample.controller.pojos;


/**
 * Contains information to edit a {@link org.sample.model.User}.
 * 
 * @author ESE Team5
 *
 */

public class ModifyUserForm{
	
	private long id;
	
    private String firstName;
	
    private String lastName;
	
    private String password;
    private String passwordControll;
    
    
    private boolean enableTutor;
    
    private String aboutYou;
    

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

	public String getAboutYou() {
		return aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

}
