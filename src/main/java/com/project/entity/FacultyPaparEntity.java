package com.project.entity;




import java.awt.Image;

import java.io.ByteArrayInputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

@Table(name = "faculty_papar")
public class FacultyPaparEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
   private String facultyname;
   @CreationTimestamp
   @Temporal(TemporalType.DATE)
   @Column(updatable = false)
   private Date date;
	private String topic;
	private String publicationdetails;
	@Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;

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
}
