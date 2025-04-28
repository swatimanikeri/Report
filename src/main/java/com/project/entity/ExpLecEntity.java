package com.project.entity;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;

import com.project.utils.DateUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob; // Add this import for LOB (Large Object) field
import jakarta.persistence.Table;
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

@Table(name = "expert_lecture") 
public class ExpLecEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srno")
    private Integer srno;
    private String topicname;
    private Date date;


    private String resourceperson;
    private String audience;
    @Column(columnDefinition = "TEXT")
	private String dynamicFieldsJson;

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
    	
    	    // Method to set the date without time using the DateUtils
    	    public void setDateWithoutTime(Date date) {
    	        this.date = DateUtils.stripTime(date);  // Strip the time part
    	    }
    
}