package com.project.entity;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Entity;  
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob; // Add this import for LOB (Large Object) field

@Entity
public class CommunityServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sr_No;
    private String activity;
    private String date;
    private String resourceperson;
    private String audience;

    // Add this field for image data
    @Lob // Large Object annotation to store large data like images
    private byte[] image1,image2;
    @SuppressWarnings("deprecation")
    
	public String generateBase64Image1() {
		return Base64.encodeBase64String(image1);
	}
    	@SuppressWarnings("deprecation")
	public String generateBase64Image2() {
		return Base64.encodeBase64String(image2);
	}
    	public byte[] getImage2() {
    		return image2;
    	}
    	public void setImage2(byte[] image2) {
    		this.image2 = image2;
    	}

    // Getters and setters
    public Integer getSr_No() {
        return sr_No;
    }

    public void setSr_No(Integer sr_No) {
        this.sr_No = sr_No;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResourceperson() {
        return resourceperson;
    }

    public void setResourceperson(String resourceperson) {
        this.resourceperson = resourceperson;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    // Getter and setter for image1
    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    // Constructors
    public CommunityServiceEntity(Integer sr_No, String activity, String date, String resourceperson, String audience, byte[] image1) {
        super();
        this.sr_No = sr_No;
        this.activity = activity;
        this.date = date;
        this.resourceperson = resourceperson;
        this.audience = audience;
        this.image1 = image1;
    }

    public CommunityServiceEntity() {
        super();
    }

    @Override
	public String toString() {
		return "CommunityServiceEntity [sr_No=" + sr_No + ", activity=" + activity + ", date=" + date
				+ ", resourceperson=" + resourceperson + ", audience=" + audience + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image1()="
				+ generateBase64Image1() + ", generateBase64Image2()=" + generateBase64Image2() + ", getSr_No()="
				+ getSr_No() + ", getActivity()=" + getActivity() + ", getDate()=" + getDate()
				+ ", getResourceperson()=" + getResourceperson() + ", getAudience()=" + getAudience() + ", getImage1()="
				+ Arrays.toString(getImage1()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
