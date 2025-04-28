package com.project.entity;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "industrial_visit")
public class IndustrialVisitEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String industrynm;
	private String date;
	private String audience;
	private String facultynm;
	@Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;

	@Lob
	private byte[] imageData,image2;
	 @SuppressWarnings("deprecation")
	public String generateBase64Image1() {
	        return Base64.encodeBase64String(imageData);
	    	

	    }
	
	
	@SuppressWarnings("deprecation")
	public String generateBase64Image2() {
	        return Base64.encodeBase64String(imageData);
	    	

	    }
	public Image getImage1AsAwt() {
        try {
            return ImageIO.read(new ByteArrayInputStream(imageData));
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
