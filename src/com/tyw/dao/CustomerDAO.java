package com.tyw.dao;

import java.util.ArrayDeque;
import java.util.Map;

import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.bean.CustomerBean;
import com.tyw.enums.Error;

public interface CustomerDAO {

	public boolean checkIfExists(String col, String val);

	public Error register(CustomerBean customer);

	public Error placeOrder(BookingBean order);

	public Error modifyOrder(BookingBean order);

	public Error cancelOrder(BookingBean order);

	public Error modifyProfile(CustomerBean customer);

	public Error deleteProfile(CustomerBean customer);

	public ArrayDeque<CarBean> searchCars(Map<String, String> params);

	public ArrayDeque<CarPoolingBean> searchCarPoolServices(Map<String, String> params);

}
