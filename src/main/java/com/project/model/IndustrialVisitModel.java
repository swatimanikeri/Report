package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class IndustrialVisitModel {
	private Integer sr_No;
	private String industrynm;
	private String date;
	private String audience;
	private String facultynm;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getIndustrynm() {
		return industrynm;
	}
	public void setIndustrynm(String industrynm) {
		this.industrynm = industrynm;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getFacultynm() {
		return facultynm;
	}
	public void setFacultynm(String facultynm) {
		this.facultynm = facultynm;
	}
	@Override
	public String toString() {
		return "IndustrialVisitModel [sr_No=" + sr_No + ", industrynm=" + industrynm + ", date=" + date + ", audience="
				+ audience + ", facultynm=" + facultynm + ", getSr_No()=" + getSr_No() + ", getIndustrynm()="
				+ getIndustrynm() + ", getDate()=" + getDate() + ", getAudience()=" + getAudience()
				+ ", getFacultynm()=" + getFacultynm() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public IndustrialVisitModel(Integer sr_No, String industrynm, String date, String audience, String facultynm) {
		super();
		this.sr_No = sr_No;
		this.industrynm = industrynm;
		this.date = date;
		this.audience = audience;
		this.facultynm = facultynm;
	}
	public IndustrialVisitModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
