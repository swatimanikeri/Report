package com.project.model;

public class CommunityServicesModel {

    private Integer sr_No;
    private String activity;
    private String date;
    private String resourceperson;
    private String audience;
    private byte[] image1,image2;  // Field for storing image data

    // Constructors
    public CommunityServicesModel() {
        super();
    }

    public CommunityServicesModel(Integer sr_No, String activity, String date, String resourceperson, String audience, byte[] image1) {
        this.sr_No = sr_No;
        this.activity = activity;
        this.date = date;
        this.resourceperson = resourceperson;
        this.audience = audience;
        this.image1 = image1;
    }

    // Getters and Setters
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

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    @Override
    public String toString() {
        return "CommunityServicesModel [sr_No=" + sr_No + ", activity=" + activity + ", date=" + date + 
               ", resourceperson=" + resourceperson + ", audience=" + audience + "]";
    }
}
