package com.project.entity;

import java.awt.Image;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Version;
@Entity
public class CompesaCsi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	private String dates;
	private String activities;
	
	@Lob
	private byte[] image1,image2;
	
	@SuppressWarnings("deprecation")
	public String generateBase64Image1() {
		return Base64.encodeBase64String(image1);
	}

	@SuppressWarnings("deprecation")
	public String generateBase64Image2() {
		return Base64.encodeBase64String(image2);
	}

	public Image getImage1AsAwt() {
	    try {
	        return ImageIO.read(new ByteArrayInputStream(image1));
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Image getImage2AsAwt() {
	    try {
	        return ImageIO.read(new ByteArrayInputStream(image2));
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public byte[] getImage1() {
		return image1;
	}


	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
	
	public CompesaCsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompesaCsi(Integer id, String dates, String activities, byte[] image1, byte[] image2) {
		super();
		this.id = id;
		this.dates = dates;
		this.activities = activities;
		this.image1 = image1;
		this.image2 = image2;
	}

	@Override
	public String toString() {
		return "CompesaCsi [id=" + id + ", dates=" + dates + ", activities=" + activities + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image1()="
				+ generateBase64Image1() + ", generateBase64Image2()=" + generateBase64Image2() + ", getImage2()="
				+ Arrays.toString(getImage2()) + ", getImage1()=" + Arrays.toString(getImage1()) + ", getId()="
				+ getId() + ", getDates()=" + getDates() + ", getActivities()=" + getActivities() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getActivities() {
		return activities;
	}
	public void setActivities(String activities) {
		this.activities = activities;
	}
	
	
}