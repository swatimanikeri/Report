package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.util.Base64;
import java.util.Arrays;

@Entity
public class ValueaddEntity {

    @Id
    private String name;

    private String resourceperson;
    private String noofparticipants;
    private String date;

    @Lob
    private byte[] image1;

    @Lob
    private byte[] image2;

    // Default constructor
    public ValueaddEntity() {
        super();
    }

    // Parameterized constructor
    public ValueaddEntity(String name, String resourceperson, String noofparticipants, String date, byte[] image1, byte[] image2) {
        this.name = name;
        this.resourceperson = resourceperson;
        this.noofparticipants = noofparticipants;
        this.date = date;
        this.image1 = image1;
        this.image2 = image2;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceperson() {
        return resourceperson;
    }

    public void setResourceperson(String resourceperson) {
        this.resourceperson = resourceperson;
    }

    public String getNoofparticipants() {
        return noofparticipants;
    }

    public void setNoofparticipants(String noofparticipants) {
        this.noofparticipants = noofparticipants;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    // Methods to convert images to Base64 strings
    public String getBase64Image1() {
        if (this.image1 != null) {
            return Base64.getEncoder().encodeToString(this.image1);
        }
        return "";
    }

    public String getBase64Image2() {
        if (this.image2 != null) {
            return Base64.getEncoder().encodeToString(this.image2);
        }
        return "";
    }

    @Override
    public String toString() {
        return "ValueaddEntity [name=" + name + ", resourceperson=" + resourceperson +
               ", noofparticipants=" + noofparticipants + ", date=" + date +
               ", image1=" + Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + "]";
    }
}
