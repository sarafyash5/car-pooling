package com.tyw.dao;

import java.util.ArrayDeque;
import java.util.Map;

import com.tyw.bean.CustomerBean;
import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.enums.Error;


public interface CustomerDAO {

	public Error register(CustomerBean customer);
	public Error login(String uid, String passwd);
	public CustomerBean getCurrentCustomer();
	public Error logout(CustomerBean customer);
	public Error placeOrder(BookingBean order);
	public Error modifyOrder(BookingBean order, String pickup, String dropoff);
	public Error cancelOrder(BookingBean order);
	public Error modifyProfile(CustomerBean customer);
	public Error deleteProfile(CustomerBean customer);
	public ArrayDeque<CarBean> searchCars(Map<String, String> params);
	public ArrayDeque<CarPoolingBean> searchCarPoolServices(Map<String, String> params);

}
