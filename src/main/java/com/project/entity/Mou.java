package com.project.entity;

import java.util.Arrays;


import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Mou {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String orgnm;
	private String activitydetails;
	@Lob
	private byte[] image1,image2;
	@Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;

	
	public String getDynamicFieldsJson() {
		return dynamicFieldsJson;
	}
	public void setDynamicFieldsJson(String dynamicFieldsJson) {
		this.dynamicFieldsJson = dynamicFieldsJson;
	}
	@SuppressWarnings("deprecation")
	public String generateBase64Image() {
		return Base64.encodeBase64String(image1);
	}
	@SuppressWarnings("deprecation")
	public String generateBase64Image2() {
		return Base64.encodeBase64String(image2);
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
	
	

	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	
	public String getOrgnm() {
		return orgnm;
	}
	public void setOrgnm(String orgnm) {
		this.orgnm = orgnm;
	}
	public String getActivitydetails() {
		return activitydetails;
	}
	public void setActivitydetails(String activitydetails) {
		this.activitydetails = activitydetails;
	}
	@Override
	public String toString() {
		return "Mou [sr_No=" + sr_No + ", orgnm=" + orgnm + ", activitydetails=" + activitydetails + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image()="
				+ generateBase64Image() + ", generateBase64Image2()=" + generateBase64Image2() + ", getImage1()="
				+ Arrays.toString(getImage1()) + ", getImage2()=" + Arrays.toString(getImage2()) + ", getSr_No()="
				+ getSr_No() + ", getOrgnm()=" + getOrgnm() + ", getActivitydetails()=" + getActivitydetails()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public Mou(Integer sr_No, String orgnm, String activitydetails, byte[] image1, byte[] image2) {
		super();
		this.sr_No = sr_No;
		this.orgnm = orgnm;
		this.activitydetails = activitydetails;
		this.image1 = image1;
		this.image2 = image2;
	}
	public Mou() {
		super();
		// TODO Auto-generated constructor stub
	}
}
