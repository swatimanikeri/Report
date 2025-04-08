package com.project.entity;




import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Entity;  
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob; // Add this import for LOB (Large Object) field

@Entity
public class ExpLecEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Srno;
    private String TopicName;
    private String DateConducted;
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
		public String getTopicName() {
			return TopicName;
		}
		public void setTopicName(String topicName) {
			TopicName = topicName;
		}
		public String getDateConducted() {
			return DateConducted;
		}
		public void setDateConducted(String dateConducted) {
			DateConducted = dateConducted;
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
			return "ExpLecEntity [TopicName=" + TopicName + ", DateConducted=" + DateConducted + ", resourceperson="
					+ resourceperson + ", audience=" + audience + ", image1=" + Arrays.toString(image1) + ", image2="
					+ Arrays.toString(image2) + ", generateBase64Image1()=" + generateBase64Image1()
					+ ", generateBase64Image2()=" + generateBase64Image2() + ", getImage2()="
					+ Arrays.toString(getImage2()) + ", getTopicName()=" + getTopicName() + ", getDateConducted()="
					+ getDateConducted() + ", getResourceperson()=" + getResourceperson() + ", getAudience()="
					+ getAudience() + ", getImage1()=" + Arrays.toString(getImage1()) + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		public ExpLecEntity(String topicName, String dateConducted, String resourceperson, String audience,
				byte[] image1, byte[] image2) {
			super();
			TopicName = TopicName;
			DateConducted = DateConducted;
			this.resourceperson = resourceperson;
			this.audience = audience;
			this.image1 = image1;
			this.image2 = image2;
		}
		public ExpLecEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

    
    	
	
    
}