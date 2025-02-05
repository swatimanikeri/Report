package com.project.entity;

import jakarta.persistence.Entity;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity


public class FacultyReg {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO )

	private Integer employee_id;
	private String full_Name;
	private String emial_id;
	private String pass;
	private String confirm_pass;
	
	/*public Integer getSr_no() {
		return sr_no;
	}
	public void setSr_no(Integer sr_no) {
		this.sr_no = sr_no;
	}*/
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFull_Name() {
		return full_Name;
	}
	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}
	public String getEmial_id() {
		return emial_id;
	}
	public void setEmial_id(String emial_id) {
		this.emial_id = emial_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	public FacultyReg( Integer sr_no,Integer employee_id, String full_Name, String emial_id, String pass, String confirm_pass) {
		super();
		//this.sr_no=sr_no;
		this.employee_id = employee_id;
		this.full_Name = full_Name;
		this.emial_id = emial_id;
		this.pass = pass;
		this.confirm_pass = confirm_pass;
	}
	public FacultyReg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FacultyReg [employee_id=\" + employee_id + \", full_Name=" + full_Name + ", emial_id=" + emial_id
				+ ", pass=" + pass + ", confirm_pass=" + confirm_pass + ", getEmployee_id()=" + getEmployee_id()
				+ ", getFull_Name()=" + getFull_Name() + ", getEmial_id()=" + getEmial_id() + ", getPass()=" + getPass()
				+ ", getConfirm_pass()=" + getConfirm_pass() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void save(FacultyReg frep) {
		// TODO Auto-generated method stub
		
	}
	


}
