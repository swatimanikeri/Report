package com.project.entity;

import java.util.Arrays;


import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class PaperbyStudents {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private Integer groupno;
	private Integer rollno;
	private String studentname;
	private String topic;
	private String paperdetails;
	
	 public PaperbyStudents(Integer sr_No, Integer groupno, Integer rollno, String studentname, String topic,
			String paperdetails, byte[] image1, byte[] image2) {
		super();
		this.sr_No = sr_No;
		this.groupno = groupno;
		this.rollno = rollno;
		this.studentname = studentname;
		this.topic = topic;
		this.paperdetails = paperdetails;
		this.image1 = image1;
		this.image2 = image2;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}
	@Lob
	    private byte[] image1, image2;

	    // Methods to convert images to Base64
	    @SuppressWarnings("deprecation")
		public String generateBase64Image1() {
	        return Base64.encodeBase64String(image1);
	    }

	    @SuppressWarnings("deprecation")
		public String generateBase64Image2() {
	        return Base64.encodeBase64String(image2);
	    }
	    
	    
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public Integer getGroupno() {
		return groupno;
	}
	public void setGroupno(Integer groupno) {
		this.groupno = groupno;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPaperdetails() {
		return paperdetails;
	}
	public void setPaperdetails(String paperdetails) {
		this.paperdetails = paperdetails;
	}
	@Override
	public String toString() {
		return "PaperbyStudents [sr_No=" + sr_No + ", groupno=" + groupno + ", rollno=" + rollno + ", studentname="
				+ studentname + ", topic=" + topic + ", paperdetails=" + paperdetails + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", getImage1()="
				+ Arrays.toString(getImage1()) + ", getImage2()=" + Arrays.toString(getImage2())
				+ ", generateBase64Image1()=" + generateBase64Image1() + ", generateBase64Image2()="
				+ generateBase64Image2() + ", getSr_No()=" + getSr_No() + ", getGroupno()=" + getGroupno()
				+ ", getRollno()=" + getRollno() + ", getStudentname()=" + getStudentname() + ", getTopic()="
				+ getTopic() + ", getPaperdetails()=" + getPaperdetails() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public PaperbyStudents(Integer sr_No, Integer groupno, Integer rollno, String studentname, String topic,
			String paperdetails) {
		super();
		this.sr_No = sr_No;
		this.groupno = groupno;
		this.rollno = rollno;
		this.studentname = studentname;
		this.topic = topic;
		this.paperdetails = paperdetails;
	}
	public PaperbyStudents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
