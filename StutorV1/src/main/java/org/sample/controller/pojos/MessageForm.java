package org.sample.controller.pojos;

import org.sample.model.User;


public class MessageForm {
	
	private String title;
	private String message;
	private User recipient;
	private long userId;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getRecipient() {
		return recipient;
	}
	public void setRecipient(User user) {
		this.recipient = user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long id) {
		this.userId = id;
	}

}
