package com.tyw.daoimpl;

import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.bean.EmployeeBean;
import com.tyw.bean.InvoiceBean;
import com.tyw.dao.EmployeeDAO;
import com.tyw.enums.BookingStatus;
import com.tyw.enums.Error;


public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Error login(EmployeeBean employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error logout(EmployeeBean employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error addCar(CarBean car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error deleteCar(CarBean car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error calculateFareAndTaxes(BookingBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error modifyOrder(BookingBean order, String pickup, String dropoff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error cancelOrder(BookingBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error assignCar(BookingBean order, String carNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error addCarPoolingService(CarPoolingBean service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error modifyNoOfPassengers(String carNum, int noOfPassengers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error editBookingRequest(BookingBean request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error updateBookingStatus(String orderNum, BookingStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceBean generateCustomerInvoice(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
