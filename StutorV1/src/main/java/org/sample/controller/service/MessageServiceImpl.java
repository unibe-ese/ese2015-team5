package org.sample.controller.service;

import java.util.Date;

import org.sample.controller.pojos.MessageForm;
import org.sample.model.Competence;
import org.sample.model.Message;
import org.sample.model.User;
import org.sample.model.dao.MessageDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	UserDao userDao;
	

	/* (non-Javadoc)
	 * @see org.sample.controller.service.MessageService#saveMessage(org.sample.controller.pojos.MessageForm)
	 */
	@Override
	public Message saveMessage(MessageForm form, User sender, User recipient) {
		Message msg = new Message();
		msg.setMessage(form.getMessage());
		msg.setTitle(form.getTitle());
		msg.setRecipient(recipient);
		msg.setSender(sender);
		msg.setTime(new Date().toString());
		return messageDao.save(msg);
	}
	
	/* (non-Javadoc)
	 * @see org.sample.controller.service.MessageService#deleteMessage(org.sample.model.Message)
	 */
	@Override
	public void deleteMessage(Message msg){
		msg.setRecipient(null);
		msg.setSender(null);
		messageDao.delete(msg);
	}

	/* (non-Javadoc)
	 * @see org.sample.controller.service.MessageService#validateComptence(org.sample.model.Competence)
	 */
	@Override
	public Competence validateComptence(Competence comp) {
		// TODO Auto-generated method stub
		return null;
	}
}
