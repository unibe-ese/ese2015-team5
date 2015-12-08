package org.sample.controller.service.test;


import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.sample.controller.pojos.ApplicationForm;
import org.sample.controller.pojos.MessageForm;
import org.sample.controller.service.ApplicationService;
import org.sample.controller.service.MessageService;
import org.sample.model.Application;
import org.sample.model.Course;
import org.sample.model.Message;
import org.sample.model.User;
import org.sample.model.dao.ApplicationDao;
import org.sample.model.dao.CourseDao;
import org.sample.model.dao.MessageDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/test.xml"})
public class MessageServiceTest {

	
	@Autowired
	MessageService messageService;
	
	@Autowired
	MessageDao messageDao;
	
	private MessageForm messageForm;
	
	private Message expectedMessage, messageToDelete;
	
	private String messageString = "Super secret stuff (sss)",
			titleString = "This message will delete itself in 5 seconds";

	private User ministerOfDefense, double0Seven;

	
	@Before
	public void setup(){
		
		ministerOfDefense = new User();
		ministerOfDefense.setId((long)1);
		double0Seven = new User();
		double0Seven.setId((long)007);
		
		messageForm = new MessageForm();
		
		messageForm.setMessage(messageString);
		messageForm.setTitle(titleString);
		messageForm.setUserId(ministerOfDefense.getId());
		messageForm.setRecipient(double0Seven);
		
		expectedMessage = new Message();
		expectedMessage.setMessage(messageString);
		expectedMessage.setTitle(titleString);
		expectedMessage.setRecipient(double0Seven);
		expectedMessage.setSender(ministerOfDefense);
		
		messageToDelete = expectedMessage;
		
		Mockito.when(messageDao.save(any(Message.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
	}
	
	@Test
	public void injectionTest(){
		assertNotNull(messageService);
	}
	
	@Test
	public void saveMessageTest(){
		Message returnedMessage = messageService.saveMessage(messageForm, ministerOfDefense, double0Seven);
		assertEquals(expectedMessage.getTitle(), returnedMessage.getTitle());
		assertEquals(expectedMessage.getMessage(), returnedMessage.getMessage());
		assertEquals(expectedMessage.getRecipient(), returnedMessage.getRecipient());
		assertEquals(expectedMessage.getSender(), returnedMessage.getSender());		
	}
	
	@Test
	public void deleteMessageTest(){
		messageService.deleteMessage(messageToDelete);
		assertNull(messageToDelete.getRecipient());
		assertNull(messageToDelete.getSender());
	}
	
	
	
}
