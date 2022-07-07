package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certficate {
	
	private String course;
	private String duration;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Certficate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certficate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Certficate [course=" + course + ", duration=" + duration + "]";
	}
	

}
