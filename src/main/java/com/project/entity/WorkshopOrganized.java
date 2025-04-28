package com.project.entity;

import java.util.Arrays;


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
@Table(name = "workshop_event")
public class WorkshopOrganized {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_no;
	private String name_of_Workshop;
	private Integer no_of_participents;
	private String date_conducted;
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

	
}

	