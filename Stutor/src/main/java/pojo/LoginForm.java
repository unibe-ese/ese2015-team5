package pojo;

/**
 * A pojo is a plane old java object
 * That means it holds only variables with its getters and setters
 * Basicaly Beans are kinda pojos too
 */

public class LoginForm {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
