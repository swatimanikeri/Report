package com.project.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name = "Expert_lecture")
public class ExpertLecture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Integer Sr_No;
	private String Topic;
	private String Resource_Person;
	private String date_conducted;
	private String audience;
	public Integer getSr_No() {
		return Sr_No;
	}
	public void setSr_No(Integer sr_No) {
		Sr_No = sr_No;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getResource_Person() {
		return Resource_Person;
	}
	public void setResource_Person(String resource_Person) {
		Resource_Person = resource_Person;
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
		return "ExpertLecture [Sr_No=" + Sr_No + ", Topic=" + Topic + ", Resource_Person=" + Resource_Person
				+ ", date_conducted=" + date_conducted + ", audience=" + audience + ", getSr_No()=" + getSr_No()
				+ ", getTopic()=" + getTopic() + ", getResource_Person()=" + getResource_Person()
				+ ", getDate_conducted()=" + getDate_conducted() + ", getAudience()=" + getAudience() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public ExpertLecture(Integer sr_No, String topic, String resource_Person, String date_conducted, String audience) {
		super();
		Sr_No = sr_No;
		Topic = topic;
		Resource_Person = resource_Person;
		this.date_conducted = date_conducted;
		this.audience = audience;
	}
	public ExpertLecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
