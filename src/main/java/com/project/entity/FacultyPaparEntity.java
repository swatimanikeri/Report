package com.project.entity;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FacultyPaparEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	public FacultyPaparEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacultyPaparEntity(Integer sr_No, String facultyname, String topic, String publicationdetails, byte[] image1,
			byte[] image2) {
		super();
		this.sr_No = sr_No;
		this.facultyname = facultyname;
		this.topic = topic;
		this.publicationdetails = publicationdetails;
		this.image1 = image1;
		this.image2 = image2;
	}
	@Override
	public String toString() {
		return "FacultyPaparEntity [sr_No=" + sr_No + ", facultyname=" + facultyname + ", topic=" + topic
				+ ", publicationdetails=" + publicationdetails + ", image1=" + Arrays.toString(image1) + ", image2="
				+ Arrays.toString(image2) + ", getSr_No()=" + getSr_No() + ", getFacultyname()=" + getFacultyname()
				+ ", getTopic()=" + getTopic() + ", getPublicationdetails()=" + getPublicationdetails()
				+ ", getImage1()=" + Arrays.toString(getImage1()) + ", getImage2()=" + Arrays.toString(getImage2())
				+ ", generateBase64Image1()=" + generateBase64Image1() + ", generateBase64Image2()="
				+ generateBase64Image2() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
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
	private String facultyname;
	private String topic;
	private String publicationdetails;
	 private byte[] image1,image2;
	    @SuppressWarnings("deprecation")
	    
		public String generateBase64Image1() {
			return Base64.encodeBase64String(image1);
		}
	    	@SuppressWarnings("deprecation")
		public String generateBase64Image2() {
			return Base64.encodeBase64String(image2);
		}
	
	
}
