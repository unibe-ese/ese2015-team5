package org.sample.controller.exceptions;

public class InvalidCourseDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCourseDateException(String m){
		super(m);
	}
	
}
