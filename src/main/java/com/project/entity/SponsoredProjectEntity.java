package com.project.entity;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "sponsored_project") // Optional: if you want to set a custom table name
public class SponsoredProjectEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sr_No;
    
    private Integer rollno;
    private String studentname;
    private String guide;
    private String projectnm;
    private String companydetails;
    
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

    // Getters and Setters
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
		return "SponsoredProjectEntity [sr_No=" + sr_No + ", rollno=" + rollno + ", studentname=" + studentname
				+ ", guide=" + guide + ", projectnm=" + projectnm + ", companydetails=" + companydetails + ", image1="
				+ Arrays.toString(image1) + ", image2=" + Arrays.toString(image2) + ", generateBase64Image1()="
				+ generateBase64Image1() + ", generateBase64Image2()=" + generateBase64Image2() + ", getSr_No()="
				+ getSr_No() + ", getRollno()=" + getRollno() + ", getStudentname()=" + getStudentname()
				+ ", getGuide()=" + getGuide() + ", getProjectnm()=" + getProjectnm() + ", getCompanydetails()="
				+ getCompanydetails() + ", getImage1()=" + Arrays.toString(getImage1()) + ", getImage2()="
				+ Arrays.toString(getImage2()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

    // Constructors
    public SponsoredProjectEntity(Integer sr_No, Integer rollno, String studentname, String guide, String projectnm,
                                  String companydetails) {
        super();
        this.sr_No = sr_No;
        this.rollno = rollno;
        this.studentname = studentname;
        this.guide = guide;
        this.projectnm = projectnm;
        this.companydetails = companydetails;
    }

    public SponsoredProjectEntity() {
        super();
    }
}
