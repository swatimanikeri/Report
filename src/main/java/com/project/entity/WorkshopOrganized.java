package com.project.entity;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class WorkshopOrganized {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String name_of_organized;
	private String no_of_participents;
	private String date_conducted;
	
	 @Lob
	    private byte[] image1, image2;

	    public WorkshopOrganized(Integer sr_No, String name_of_organized, String no_of_participents, String date_conducted,
			byte[] image1, byte[] image2) {
		super();
		this.sr_No = sr_No;
		this.name_of_organized = name_of_organized;
		this.no_of_participents = no_of_participents;
		this.date_conducted = date_conducted;
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
	public String getName_of_organized() {
		return name_of_organized;
	}
	public void setName_of_organized(String name_of_organized) {
		this.name_of_organized = name_of_organized;
	}
	public String getNo_of_participents() {
		return no_of_participents;
	}
	public void setNo_of_participents(String no_of_participents) {
		this.no_of_participents = no_of_participents;
	}
	public String getDate_conducted() {
		return date_conducted;
	}
	public void setDate_conducted(String date_conducted) {
		this.date_conducted = date_conducted;
	}
	@Override
	public String toString() {
		return "WorkshopOrganized [sr_No=" + sr_No + ", name_of_organized=" + name_of_organized
				+ ", no_of_participents=" + no_of_participents + ", date_conducted=" + date_conducted + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", getImage1()="
				+ Arrays.toString(getImage1()) + ", getImage2()=" + Arrays.toString(getImage2())
				+ ", generateBase64Image1()=" + generateBase64Image1() + ", generateBase64Image2()="
				+ generateBase64Image2() + ", getSr_No()=" + getSr_No() + ", getName_of_organized()="
				+ getName_of_organized() + ", getNo_of_participents()=" + getNo_of_participents()
				+ ", getDate_conducted()=" + getDate_conducted() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public WorkshopOrganized(Integer sr_No, String name_of_organized, String no_of_participents,
			String date_conducted) {
		super();
		this.sr_No = sr_No;
		this.name_of_organized = name_of_organized;
		this.no_of_participents = no_of_participents;
		this.date_conducted = date_conducted;
	}
	public WorkshopOrganized() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
