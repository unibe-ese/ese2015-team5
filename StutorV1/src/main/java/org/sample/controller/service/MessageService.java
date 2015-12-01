package org.sample.controller.service;

import org.sample.controller.pojos.MessageForm;
import org.sample.model.Competence;
import org.sample.model.Message;
import org.sample.model.User;

public interface MessageService {

	public abstract void deleteMessage(Message msg);

	public abstract Competence validateComptence(Competence comp);

	public abstract Message saveMessage(MessageForm form, User sender, User recipient);

}