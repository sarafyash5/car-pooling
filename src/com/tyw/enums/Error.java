package com.tyw.enums;

public enum Error {
	SUCCESS(0, ""),
	DUPLICATE(1, "This user already exists"),
	INCORRECTPASSWORD(2, "The password is incorrect"),
	USERNOTEXIST(3, "The user ID does not exist"),
	DATABASE(4, "A database error has occurred"),
	WALLET(5, "Your wallet does not have sufficient funds");

	private final int code;
	private final String description;

	private Error(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}