package org.sample.controller.pojos;

import org.sample.model.User;

public interface NewsFeedArticleInterface {

	public User getPartner();
	
	public boolean isTutorCourse();
	
	public String getDateRepresentation();
	
	public String toString();
	
}
