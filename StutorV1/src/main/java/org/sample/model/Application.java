package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Application {
	
	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private User master;
	
	@ManyToOne
	private User slave;
	
	@OneToOne
	private Course course;

	public User getMaster() {
		return master;
	}

	public void setMaster(User master) {
		this.master = master;
	}

	public User getSlave() {
		return slave;
	}

	public void setSlave(User slave) {
		this.slave = slave;
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
}
