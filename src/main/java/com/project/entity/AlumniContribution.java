package com.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



public class AlumniContribution {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer sr_No;
	private String topic;
	private String resource_Person;
	private String date_conducted;
	private String audience;
	public Integer getSr_No() {
		return sr_No;
	}
	public void setSr_No(Integer sr_No) {
		this.sr_No = sr_No;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getResource_Person() {
		return resource_Person;
	}
	public void setResource_Person(String resource_Person) {
		this.resource_Person = resource_Person;
	}
	public String getDate_conducted() {
		return date_conducted;
	}
	public void setDate_conducted(String date_conducted) {
		this.date_conducted = date_conducted;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	@Override
	public String toString() {
		return "AlumniContribution [sr_No=" + sr_No + ", topic=" + topic + ", resource_Person=" + resource_Person
				+ ", date_conducted=" + date_conducted + ", audience=" + audience + ", getSr_No()=" + getSr_No()
				+ ", getTopic()=" + getTopic() + ", getResource_Person()=" + getResource_Person()
				+ ", getDate_conducted()=" + getDate_conducted() + ", getAudience()=" + getAudience() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public AlumniContribution(Integer sr_No, String topic, String resource_Person, String date_conducted,
			String audience) {
		super();
		this.sr_No = sr_No;
		this.topic = topic;
		this.resource_Person = resource_Person;
		this.date_conducted = date_conducted;
		this.audience = audience;
	}
	public AlumniContribution() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
