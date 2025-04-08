package com.project.model;

import jakarta.persistence.Version;

public class compesaModel {
	private Integer sr_No;
	private String dates;
	private String activities;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getActivities() {
		return activities;
	}
	public void setActivities(String activities) {
		this.activities = activities;
	}
	@Override
	public String toString() {
		return "compesaModel [sr_No=" + sr_No + ", dates=" + dates + ", activities=" + activities + ", getSr_No()=" + getSr_No() + ", getDates()="
				+ getDates() + ", getActivities()=" + getActivities() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public compesaModel(Integer sr_No, String dates, String activities) {
		super();
		this.sr_No = sr_No;
		this.dates = dates;
		this.activities = activities;
//		this.version = version;
	}
	public compesaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
