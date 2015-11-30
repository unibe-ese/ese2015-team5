package org.sample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Represents a registered User of Stutor.
 * 
 * @field firstName, lastName: The complete Name of a User.
 * @field email: Used to login.
 * @field password: Used to authenticate.
 * @field aboutYou: A description of a User.
 * @field pic: {@ProfilePicture} of the User
 * @field competences: A list of {@Competence} a User might offer.
 * @field enableTutor: A boolean indicating if he offers tutoring at the moment. (Used for Competences) 
 * 
 * @author ESE Team5
 *
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    private float houerlyRate;
    
    private float balance;

	private String aboutYou;
    
    @OneToOne
    private ProfilePicture pic;

	@OneToMany(fetch = FetchType.EAGER, targetEntity=Competence.class, mappedBy="owner", cascade=CascadeType.DETACH)
    private List<Competence> competences;
    
    private boolean enableTutor;
    
    @OneToMany(fetch = FetchType.EAGER, targetEntity=Course.class, mappedBy="owner", cascade=CascadeType.DETACH)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Course> courses;
    
    @OneToMany(fetch = FetchType.EAGER, targetEntity=Application.class, mappedBy="master", cascade=CascadeType.DETACH)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Application> myTutorApplications;
    
    @OneToMany(fetch = FetchType.EAGER, targetEntity=Application.class, mappedBy="slave", cascade=CascadeType.DETACH)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Application> myApplications;
      
    public ProfilePicture getPic() {
		return pic;
	}

	public void setPic(ProfilePicture pic) {
		this.pic = pic;
	}
    
    public void setCompetences(List<Competence> competences){
    	this.competences = competences;
    }
    
    public List<Competence> getCompetences(){
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aboutYou == null) ? 0 : aboutYou.hashCode());
		result = prime * result
				+ ((competences == null) ? 0 : competences.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enableTutor ? 1231 : 1237);
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Application> getMyTutorApplications() {
		return myTutorApplications;
	}

	public void setMyTutorApplications(List<Application> myTutorApplications) {
		this.myTutorApplications = myTutorApplications;
	}

	public List<Application> getMyApplications() {
		return myApplications;
	}

	public void setMyApplications(List<Application> myApplications) {
		this.myApplications = myApplications;
	}

	public float getHouerlyRate() {
		return houerlyRate;
	}

	public void setHouerlyRate(float houerlyRate) {
		this.houerlyRate = houerlyRate;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
