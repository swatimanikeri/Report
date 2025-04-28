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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity

public class PaperbyStudents {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private Integer groupno;
	private Integer rollno;
	private String studentname;
	private String topic;
	private String paperdetails;
	@Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;
	
	
	@Lob
	    private byte[] image1, image2;

	    // Methods to convert images to Base64
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

	
}
