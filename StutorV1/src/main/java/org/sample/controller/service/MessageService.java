package org.sample.controller.service;

import org.sample.controller.pojos.MessageForm;
import org.sample.model.Message;
import org.sample.model.User;

public interface MessageService {

	public void deleteMessage(Message msg);

	public Message saveMessage(MessageForm form, User sender, User recipient);

}