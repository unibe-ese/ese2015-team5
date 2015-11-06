package org.sample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.SignupForm;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String aboutYou = null;

	@OneToOne
	private ProfilePicture pic;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Competence.class, mappedBy = "owner", cascade = CascadeType.DETACH)
	private List<Competence> competences;

	private boolean enableTutor = false;

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public User() {

	}
	
	public User(SignupForm signup, ProfilePicture pic) throws InvalidUserException {
		this.id = signup.getId();
		this.firstName = signup.getFirstName();
		this.lastName = signup.getLastName();
		this.email = signup.getEmail();
		this.password = signup.getPassword();
		
		this.pic = pic;
	}

	public User update(ModifyUserForm mod) {
		this.setFirstName(mod.getFirstName());
		this.setLastName(mod.getLastName());
		this.setPassword(mod.getPassword());
		this.setEnableTutor(mod.getEnableTutor());
		this.setAboutYou(mod.getAboutYou());
		return this;
	}

	public ProfilePicture getPic() {
		return pic;
	}

	public void setPic(ProfilePicture pic) {
		this.pic = pic;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
