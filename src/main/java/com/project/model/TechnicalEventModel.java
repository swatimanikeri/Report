package com.project.model;

import java.util.Arrays;

public class TechnicalEventModel {

    private Long id;  // Primary key

    private String studentname;
    private String event;
    private String date;
    private String organisedby;
    private String status;
    private boolean isDeleted;
    private byte[] image1; 

    // ✅ Fix the incorrect class name in the constructor
    public TechnicalEventModel() {
    }

    // ✅ Fix the constructor name (should match the class name)
    public TechnicalEventModel(String studentname, String event, String date, String organisedby, String status, byte[] image1) {
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

    // ✅ Fix `toString()` method to use the correct class name
    @Override
    public String toString() {
        return "TechnicalEventModel{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", event='" + event + '\'' +
                ", date='" + date + '\'' +
                ", organisedby='" + organisedby + '\'' +
                ", status='" + status + '\'' +
                ", image1=" + (image1 != null ? Arrays.toString(Arrays.copyOf(image1, 10)) + "..." : "null") +
                '}';
    }

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
