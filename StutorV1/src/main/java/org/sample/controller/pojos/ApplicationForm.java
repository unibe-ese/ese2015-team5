package org.sample.controller.pojos;

import org.sample.model.Course;
import org.sample.model.User;

public class ApplicationForm {

	Course course;
	
	User applicant;
	
	public ApplicationForm(){
		
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
}
