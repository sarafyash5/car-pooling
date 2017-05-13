package com.tyw.bean;

import java.io.Serializable;


public class CarPoolingBean implements Serializable {

	private String poolingId;
	private String carNumber;
	private double driverSalary;
	private double fare;
	private String origin;
	private String destination;
	private String departure;

	public String getPoolingId() {
		return poolingId;
	}

	public void setPoolingId(String poolingId) {
		this.poolingId = poolingId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public double getDriverSalary() {
		return driverSalary;
	}

	public void setDriverSalary(double driverSalary) {
		this.driverSalary = driverSalary;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

}