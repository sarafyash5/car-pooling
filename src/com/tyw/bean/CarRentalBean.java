package com.tyw.bean;

import java.io.Serializable;


public class CarRentalBean implements Serializable {

	private String rentalId;
	private String carNumber;
	private double ratePerKm;
	private double kmTravelled;
	private double basicRent;
	private String location;

	public String getRentalId() {
		return rentalId;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public double getKmTravelled() {
		return kmTravelled;
	}

	public void setKmTravelled(double kmTravelled) {
		this.kmTravelled = kmTravelled;
	}

	public double getBasicRent() {
		return basicRent;
	}

	public void setBasicRent(double basicRent) {
		this.basicRent = basicRent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}