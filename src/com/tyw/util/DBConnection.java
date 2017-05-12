package com.tyw.util;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;


public final class DBConnection {

	private static Connection conn = null;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	private DBConnection() {}

	public static Connection getConnection() {
		if (conn == null)
			getNewConnection();
		return conn;
	}

	private static void getNewConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				OracleDataSource ods = new OracleDataSource();
				ods.setURL(URL);
				conn = ods.getConnection("hr", "1234");
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}