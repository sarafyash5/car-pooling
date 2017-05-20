package com.tyw.enums;

public enum Role {
	EMPLOYEE("employee"), CUSTOMER("customer");
	
	private final String table;
	
	private Role(String table) {
		this.table = table;
	}
	
	public String getTable() {
		return table;
	}
}
