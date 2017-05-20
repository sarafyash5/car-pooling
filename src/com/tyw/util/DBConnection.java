package com.tyw.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public final class DBConnection {

	private static Connection conn = null;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String UniqueValQuery = "select getUniqueVal() from dual";
	private static PreparedStatement ps = null;

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException {
		if (conn == null)
			createConnection();
		return conn;
	}

	private static void createConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(URL);
			conn = ods.getConnection("hr", "1234");
			ps = getConnection().prepareStatement(UniqueValQuery);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String getUniqueString() throws SQLException {
		if (ps == null) createConnection();
		try (ResultSet rs = ps.executeQuery()) {
			if (!rs.next()) {
				throw new SQLException("Error while generate unique string");
			}
			return rs.getString(1);
		}
	}

}
