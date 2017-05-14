package com.tyw.daoimpl;

import java.util.ArrayDeque;
import java.util.Map;

import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.bean.CustomerBean;
import com.tyw.dao.CustomerDAO;
import com.tyw.enums.Error;


public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Error register(CustomerBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error login(String uid, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerBean getCurrentCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error logout(CustomerBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error placeOrder(BookingBean order) {
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
	public Error modifyProfile(CustomerBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error deleteProfile(CustomerBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayDeque<CarBean> searchCars(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayDeque<CarPoolingBean> searchCarPoolServices(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
