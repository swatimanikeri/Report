package com.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FacultyInteraction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String activity;
	private String facultynm;
	private String Institutenm;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getFacultynm() {
		return facultynm;
	}
	public void setFacultynm(String facultynm) {
		this.facultynm = facultynm;
	}
	public String getInstitutenm() {
		return Institutenm;
	}
	public void setInstitutenm(String institutenm) {
		Institutenm = institutenm;
	}
	@Override
	public String toString() {
		return "FacultyInteraction [sr_No=" + sr_No + ", activity=" + activity + ", facultynm=" + facultynm
				+ ", Institutenm=" + Institutenm + ", getSr_No()=" + getSr_No() + ", getActivity()=" + getActivity()
				+ ", getFacultynm()=" + getFacultynm() + ", getInstitutenm()=" + getInstitutenm() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public FacultyInteraction(Integer sr_No, String activity, String facultynm, String institutenm) {
		super();
		this.sr_No = sr_No;
		this.activity = activity;
		this.facultynm = facultynm;
		Institutenm = institutenm;
	}
	public FacultyInteraction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
