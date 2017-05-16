package com.tyw.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.Map;

import com.tyw.bean.BookingBean;
import com.tyw.bean.CarBean;
import com.tyw.bean.CarPoolingBean;
import com.tyw.bean.CustomerBean;
import com.tyw.dao.CustomerDAO;
import com.tyw.enums.Error;
import com.tyw.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	Connection conn = null;
	// Statement stmt = null;

	@Override
	public Error register(CustomerBean customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error login(String uid, String passwd) {
		try {
			conn = DBConnection.getConnection();
			try (Statement stmt = conn.createStatement()) {
				String query = "select passwd from customer where login_id=\'" + uid + "\'";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					return Error.USERNOTEXIST;
				}
				if (!passwd.equals(rs.getString(1))) {
					return Error.INCORRECTPASSWORD;
				}
			}
		} catch (SQLException e) {
			return Error.DATABASE;
		}
		return Error.SUCCESS;
	}
	
//	public String login1(String uid, String passwd) {
//		try {
//			conn = DBConnection.getConnection();
//			try (Statement stmt = conn.createStatement()) {
//				String query = "select passwd from customer where login_id=\'" + uid + "\'";
//				if (stmt.execute(query)) {
//					ResultSet rs = stmt.getResultSet();
//					rs.next();
//					return String.valueOf(passwd.equals(rs.getString(1)));
//				}
//			}
//		} catch (SQLException e) {
//			return e.getMessage();
//		}
//		return null;
//	}

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
