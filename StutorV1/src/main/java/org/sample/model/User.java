package org.sample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private String aboutYou;
    
    @OneToOne
    private ProfilePicture pic;

	@OneToMany(fetch = FetchType.EAGER, targetEntity=Competence.class, mappedBy="owner", cascade=CascadeType.DETACH)
    private List<Competence> competences;
    
    private boolean enableTutor;
    
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
	
}