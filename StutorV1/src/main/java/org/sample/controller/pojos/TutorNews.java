package org.sample.controller.pojos;

import org.sample.model.User;

public class TutorNews implements NewsFeedArticleInterface {

	private User partner;
	
	private String dateRepresentation;
	
	public final boolean tutorCourse = true;
	
	@Override
	public User getPartner() {
		return partner;
	}
	
	public void setPartner(User partner) {
		this.partner = partner;
	}


	@Override
	public String getDateRepresentation() {
		return dateRepresentation;
	}

	public void setDateRepresentation(String dateRepresentation) {
		this.dateRepresentation = dateRepresentation;
	}

	@Override
	public boolean isTutorCourse() {
		return tutorCourse;
	}
	
	
	@Override
	public String toString(){
		return "StudentNews: Partner=[" + partner.toString() + "], Date: "  + dateRepresentation;
	}

}
