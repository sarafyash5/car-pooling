package com.tyw.enums;

public enum Error {
	SUCCESS(""),
	DUPLICATE("This user already exists"),
	INCORRECTPASSWORD("The password is incorrect"),
	USERNOTEXIST("The user ID does not exist"),
	DATABASE("A database error has occurred"),
	WALLET("Your wallet does not have sufficient funds");

	private final String description;

	private Error(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}