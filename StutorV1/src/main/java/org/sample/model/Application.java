package org.sample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * Represents an application, that a student ({@link User}) sends to a Tutor ({@link User}) for a certain
 * {@link Course}. If accepted, the course will be reserved for the student.
 * 
 * @field: tutor: The owner of the course
 * @field: student: The applicant.
 * @field: course: The course, the student wants to reserve.
 * 
 * @author ESE Team5
 *
 */

@Entity
public class Application {
	
	public static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	
	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private User tutor;
	
	@ManyToOne
	private User student;
	
	@OneToOne
	private Course course;
	
	private String dateRepresentation;
	

	public User getTutor() {
		return tutor;
	}

	public void setTutor(User master) {
		this.tutor = master;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User slave) {
		this.student = slave;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isInThePast() {
		return course.isInThePast();
	}

	public String getDateRepresentation() {
		DateFormat format = FORMAT;
		this.dateRepresentation = format.format(course.getDate());
		return dateRepresentation;
	}
	
	public Date getDate(){
		return this.course.getDate();
	}
}
