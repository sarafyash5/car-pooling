package com.tyw.bean;

import com.tyw.enums.Qualification;

import java.io.Serializable;


public class EmployeeBean implements Serializable {

	private String id;
	private Qualification qualification;
	private String location;
	private String uid;
	private String passwd;

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUID() {
		return uid;
	}

	public void setUID(String uid) {
		this.uid = uid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
