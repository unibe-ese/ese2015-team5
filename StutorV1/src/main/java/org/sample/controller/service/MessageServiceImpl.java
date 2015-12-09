package org.sample.controller.service;

import java.util.Calendar;
import java.util.Date;

import org.sample.controller.pojos.MessageForm;
import org.sample.model.Message;
import org.sample.model.User;
import org.sample.model.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageDao messageDao;
	
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
		Calendar cal = Calendar.getInstance();
		msg.setDate(cal.getTime());
		msg.setTime(cal.getTime().toString());
		return messageDao.save(msg);
	}

	@Override
	public void deleteMessage(Message msg){
		msg.setRecipient(null);
		msg.setSender(null);
		messageDao.delete(msg);
	}

}
