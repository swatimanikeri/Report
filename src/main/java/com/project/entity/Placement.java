package com.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Placement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String componynm;
	private Integer studentnm;
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
	public Integer getStudentnm() {
		return studentnm;
	}
	public void setStudentnm(Integer studentnm) {
		this.studentnm = studentnm;
	}
	@Override
	public String toString() {
		return "Placement [sr_No=" + sr_No + ", componynm=" + componynm + ", studentnm=" + studentnm + ", getSr_No()="
				+ getSr_No() + ", getComponynm()=" + getComponynm() + ", getStudentnm()=" + getStudentnm()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public Placement(Integer sr_No, String componynm, Integer studentnm) {
		super();
		this.sr_No = sr_No;
		this.componynm = componynm;
		this.studentnm = studentnm;
	}
	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
