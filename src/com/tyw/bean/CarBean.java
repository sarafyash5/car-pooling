package com.tyw.bean;

import java.io.Serializable;

import com.tyw.enums.Availability;
import com.tyw.enums.CarType;
import com.tyw.enums.OrderType;

@SuppressWarnings("serial")
public class CarBean implements Serializable {

	private String carNumber;
	private String carName;
	private CarType carType;
	private OrderType orderType;
	private Availability availability;
	private int noOfPassengers;
	private double maintenanceCost;
	private double fuelCost;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public double getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}

}