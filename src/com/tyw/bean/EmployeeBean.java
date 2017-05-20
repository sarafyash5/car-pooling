package com.tyw.bean;

import java.io.Serializable;

import com.tyw.enums.Qualification;

@SuppressWarnings("serial")
public class EmployeeBean extends UserBean implements Serializable {

	private String id;
	private Qualification qualification;
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}
