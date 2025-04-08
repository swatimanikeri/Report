package com.project.entity;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
public class IndustrialVisitEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String industrynm;
	private String date;
	private String audience;
	private String facultynm;
	@Lob
	private byte[] imageData,image2;
	 @SuppressWarnings("deprecation")
	public String generateBase64Image1() {
	        return Base64.encodeBase64String(imageData);
	    	

	    }
	 public byte[] getImage2() {
		return image2;
	}
	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}
	@SuppressWarnings("deprecation")
	public String generateBase64Image2() {
	        return Base64.encodeBase64String(imageData);
	    	

	    }


	public IndustrialVisitEntity(Integer sr_No, String industrynm, String date, String audience, String facultynm,
			byte[] imageData) {
		super();
		this.sr_No = sr_No;
		this.industrynm = industrynm;
		this.date = date;
		this.audience = audience;
		this.facultynm = facultynm;
		this.imageData = imageData;
	}


	public byte[] getImageData() {
		return imageData;
	}


	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}


	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getIndustrynm() {
		return industrynm;
	}
	public void setIndustrynm(String industrynm) {
		this.industrynm = industrynm;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getFacultynm() {
		return facultynm;
	}
	public void setFacultynm(String facultynm) {
		this.facultynm = facultynm;
	}
	@Override
	public String toString() {
		return "IndustrialVisitEntity [sr_No=" + sr_No + ", industrynm=" + industrynm + ", date=" + date + ", audience="
				+ audience + ", facultynm=" + facultynm + ", imageData=" + Arrays.toString(imageData) + ", image2="
				+ Arrays.toString(image2) + ", generateBase64Image1()=" + generateBase64Image1()
				+ ", generateBase64Image2()=" + generateBase64Image2() + ", getImageData()="
				+ Arrays.toString(getImageData()) + ", getSr_No()=" + getSr_No() + ", getIndustrynm()="
				+ getIndustrynm() + ", getDate()=" + getDate() + ", getAudience()=" + getAudience()
				+ ", getFacultynm()=" + getFacultynm() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	public IndustrialVisitEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
