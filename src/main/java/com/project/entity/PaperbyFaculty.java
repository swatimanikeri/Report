package com.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PaperbyFaculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String facultyname;
	private String topic;
	private String publicationdetails;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getFacultyname() {
		return facultyname;
	}
	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPublicationdetails() {
		return publicationdetails;
	}
	public void setPublicationdetails(String publicationdetails) {
		this.publicationdetails = publicationdetails;
	}
	@Override
	public String toString() {
		return "PaperbyFaculty [sr_No=" + sr_No + ", facultyname=" + facultyname + ", topic=" + topic
				+ ", publicationdetails=" + publicationdetails + ", getSr_No()=" + getSr_No() + ", getFacultyname()="
				+ getFacultyname() + ", getTopic()=" + getTopic() + ", getPublicationdetails()="
				+ getPublicationdetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public PaperbyFaculty(Integer sr_No, String facultyname, String topic, String publicationdetails) {
		super();
		this.sr_No = sr_No;
		this.facultyname = facultyname;
		this.topic = topic;
		this.publicationdetails = publicationdetails;
	}
	public PaperbyFaculty() {
		super();
		// TODO Auto-generated constructor stub
	}

}
