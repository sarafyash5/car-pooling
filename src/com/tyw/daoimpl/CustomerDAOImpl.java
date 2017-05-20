package com.tyw.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	private static final String INSERTUSERDETAILS = "insert into user_details values (?,?,INITCAP(?),INITCAP(?),?)";
	private static final String INSERTCUSTOMER = "insert into customer (customer_id, user_id, phone, email, license, address) values(?,?,?,LOWER(?),UPPER(?),?)";
	Connection conn = null;

	@Override
	public boolean checkIfExists(String col, String val) {
		String query = "select * from customer c join user_details u on c.user_id=u.user_id where " + col + "=?";
		try {
			conn = DBConnection.getConnection();
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, val);
				if (!stmt.executeQuery().next()) {
					return false;
				}
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public Error register(CustomerBean customer) {
		try {
			conn = DBConnection.getConnection();
			customer.setUserId(DBConnection.getUniqueString());
			customer.setId(DBConnection.getUniqueString());
			try (PreparedStatement stmt = conn.prepareStatement(INSERTUSERDETAILS)) {
				stmt.setString(1, customer.getUserId());
				stmt.setString(2, customer.getLoginId());
				stmt.setString(3, customer.getFname());
				stmt.setString(4, customer.getLname());
				stmt.setString(5, customer.getPasswd());
				if (stmt.executeUpdate() == 0) {
					throw new SQLException("Error while inserting user details");
				}
			}
			try (PreparedStatement stmt = conn.prepareStatement(INSERTCUSTOMER)) {
				stmt.setString(1, customer.getId());
				stmt.setString(2, customer.getUserId());
				stmt.setLong(3, customer.getPhone());
				stmt.setString(4, customer.getEmail());
				stmt.setString(5, customer.getLicenseNo());
				stmt.setString(6, customer.getPostalAddress());
				if (stmt.executeUpdate() == 0) {
					throw new SQLException("Error while inserting customer details");
				}
			}
		} catch (SQLException e) {
			return Error.DATABASE;
		}
		return Error.SUCCESS;
	}

	// public String login1(String loginId, String passwd) {
	// try {
	// conn = DBConnection.getConnection();
	// try (Statement stmt = conn.createStatement()) {
	// String query = "select passwd from customer where login_id=\'" + loginId
	// +
	// "\'";
	// if (stmt.execute(query)) {
	// ResultSet rs = stmt.getResultSet();
	// rs.next();
	// return String.valueOf(passwd.equals(rs.getString(1)));
	// }
	// }
	// } catch (SQLException e) {
	// return e.getMessage();
	// }
	// return null;
	// }

	@Override
	public Error placeOrder(BookingBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error modifyOrder(BookingBean order) {
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
