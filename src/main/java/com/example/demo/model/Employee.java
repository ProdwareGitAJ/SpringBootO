package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString

@Document(collection="Employee_Master")
public class Employee {
	@Id
	private String user_Id;
	
	private String fName,lName,dob,email_id,addr,c_no,job_type,loc,bus_unit,cadr,alt_no,skills,j_date,l_date;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getBus_unit() {
		return bus_unit;
	}

	public void setBus_unit(String bus_unit) {
		this.bus_unit = bus_unit;
	}

	public String getCadr() {
		return cadr;
	}

	public void setCadr(String cadr) {
		this.cadr = cadr;
	}

	public String getAlt_no() {
		return alt_no;
	}

	public void setAlt_no(String alt_no) {
		this.alt_no = alt_no;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJ_date() {
		return j_date;
	}

	public void setJ_date(String j_date) {
		this.j_date = j_date;
	}

	public String getL_date() {
		return l_date;
	}

	public void setL_date(String l_date) {
		this.l_date = l_date;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	

	//getters and setters
	
}