package com.project.entity;

import jakarta.persistence.*; // Ensure correct imports
import java.util.Arrays;

import java.util.Base64;


@Entity
@Table(name = "technical_event")
public class TechnicalEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    private String studentname;
    private String event;
    private String date;
    private String organisedby;
    private String status;
    private boolean isDeleted;

    @Lob // Marks this field as a large object (BLOB)
    private byte[] image1,image2; 

    // ✅ Add an explicit no-args constructor
    public TechnicalEventEntity() {
    }

   
    public String generateBase64Image1() {
        return (image1 != null) ? Base64.getEncoder().encodeToString(image1) : "";
    }
    public byte[] getImage2() {
		return image2;
	}


	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}


	public String generateBase64Image2() {
        return (image1 != null) ? Base64.getEncoder().encodeToString(image2) : "";
    }

    
    // ✅ Add a parameterized constructor (optional)
    public TechnicalEventEntity(String studentname, String event, String date, String organisedby, String status, byte[] image1) {
        this.studentname = studentname;
        this.event = event;
        this.date = date;
        this.organisedby = organisedby;
        this.status = status;
        this.image1 = image1;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganisedby() {
        return organisedby;
    }

    public void setOrganisedby(String organisedby) {
        this.organisedby = organisedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    @Override
	public String toString() {
		return "TechnicalEventEntity [id=" + id + ", studentname=" + studentname + ", event=" + event + ", date=" + date
				+ ", organisedby=" + organisedby + ", status=" + status + ", isDeleted=" + isDeleted + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image1()="
				+ generateBase64Image1() + ", generateBase64Image2()=" + generateBase64Image2() + ", getId()=" + getId()
				+ ", getStudentname()=" + getStudentname() + ", getEvent()=" + getEvent() + ", getDate()=" + getDate()
				+ ", getOrganisedby()=" + getOrganisedby() + ", getStatus()=" + getStatus() + ", getImage1()="
				+ Arrays.toString(getImage1()) + ", isDeleted()=" + isDeleted() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
