package com.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Internships {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String componynm;
	private Integer totalstudents;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getComponynm() {
		return componynm;
	}
	public void setComponynm(String componynm) {
		this.componynm = componynm;
	}
	public Integer getTotalstudents() {
		return totalstudents;
	}
	public void setTotalstudents(Integer totalstudents) {
		this.totalstudents = totalstudents;
	}
	@Override
	public String toString() {
		return "Internships [sr_No=" + sr_No + ", componynm=" + componynm + ", totalstudents=" + totalstudents
				+ ", getSr_No()=" + getSr_No() + ", getComponynm()=" + getComponynm() + ", getTotalstudents()="
				+ getTotalstudents() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public Internships(Integer sr_No, String componynm, Integer totalstudents) {
		super();
		this.sr_No = sr_No;
		this.componynm = componynm;
		this.totalstudents = totalstudents;
	}
	public Internships() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}