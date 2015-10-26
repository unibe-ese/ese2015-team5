package org.sample.controller.pojos;



public class ModifyUserForm{
	
	private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordControll;

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
}
