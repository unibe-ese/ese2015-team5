package org.sample.model;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
=======
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
>>>>>>> refs/remotes/origin/master


@Entity
public class Address {
	  @Id
	    @GeneratedValue
	    private Long id;

	    private String street;
	    


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}
	    
	    
	  
}
