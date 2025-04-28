package com.project.entity;

import jakarta.persistence.*; // Ensure correct imports

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
    @Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;

    @Lob // Marks this field as a large object (BLOB)
    private byte[] image1,image2; 

  

   
    public String generateBase64Image1() {
        return (image1 != null) ? Base64.getEncoder().encodeToString(image1) : "";
    }
  
	public String generateBase64Image2() {
        return (image1 != null) ? Base64.getEncoder().encodeToString(image2) : "";
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
}