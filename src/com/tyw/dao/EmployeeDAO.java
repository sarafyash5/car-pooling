package com.tyw.dao;

import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.bean.EmployeeBean;
import com.tyw.bean.InvoiceBean;
import com.tyw.enums.BookingStatus;
import com.tyw.enums.Error;

public interface EmployeeDAO {

	public Error addCar(CarBean car);

	public Error deleteCar(CarBean car);

	public Error calculateFareAndTaxes(BookingBean order);

	public Error modifyOrder(BookingBean order);

	public Error cancelOrder(BookingBean order);

	public Error assignCar(BookingBean order, String carNum);

	public Error addCarPoolingService(CarPoolingBean service);

	public Error modifyNoOfPassengers(String carNum, int noOfPassengers);

	public Error editBookingRequest(BookingBean request);

	public Error updateBookingStatus(String orderNum, BookingStatus status);

	public InvoiceBean generateCustomerInvoice(String orderNum);

}
