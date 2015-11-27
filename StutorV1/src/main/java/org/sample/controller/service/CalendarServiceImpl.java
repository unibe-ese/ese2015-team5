package org.sample.controller.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl{

	public static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	public DateFormat getFormat() {
		return FORMAT;
	}



}
