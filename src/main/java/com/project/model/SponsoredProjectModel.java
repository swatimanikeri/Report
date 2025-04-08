package com.project.model;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class SponsoredProjectModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private Integer rollno;
	private String studentname;
	private String guide;
	private String projectnm;
	
	@Column(name = "companydetails") 
	private String companydetails;
	@Lob
	private byte[] image1,image2;
	
	 public String generateBase64Image1() {
	        return Base64.encodeBase64String(image1);
	    	}
	 public String generateBase64Image2() {
	        return Base64.encodeBase64String(image2);
	    	  }
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getProjectnm() {
		return projectnm;
	}
	public void setProjectnm(String projectnm) {
		this.projectnm = projectnm;
	}
	public String getCompanydetails() {
		return companydetails;
	}
	public void setCompanydetails(String companydetails) {
		this.companydetails = companydetails;
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
	@Override
	public String toString() {
		return "SponsoredProjectModel [sr_No=" + sr_No + ", rollno=" + rollno + ", studentname=" + studentname
				+ ", guide=" + guide + ", projectnm=" + projectnm + ", companydetails=" + companydetails + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image1()="
				+ generateBase64Image1() + ", generateBase64Image2()=" + generateBase64Image2() + ", getSr_No()="
				+ getSr_No() + ", getRollno()=" + getRollno() + ", getStudentname()=" + getStudentname()
				+ ", getGuide()=" + getGuide() + ", getProjectnm()=" + getProjectnm() + ", getCompanydetails()="
				+ getCompanydetails() + ", getImage1()=" + Arrays.toString(getImage1()) + ", getImage2()="
				+ Arrays.toString(getImage2()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public SponsoredProjectModel(Integer sr_No, Integer rollno, String studentname, String guide, String projectnm,
			String companydetails, byte[] image1, byte[] image2) {
		super();
		this.sr_No = sr_No;
		this.rollno = rollno;
		this.studentname = studentname;
		this.guide = guide;
		this.projectnm = projectnm;
		this.companydetails = companydetails;
		this.image1 = image1;
		this.image2 = image2;
	}
	public SponsoredProjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
