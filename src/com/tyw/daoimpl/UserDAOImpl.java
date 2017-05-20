package com.tyw.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tyw.bean.UserBean;
import com.tyw.dao.UserDAO;
import com.tyw.enums.Error;
import com.tyw.enums.Role;
import com.tyw.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;
	
	@Override
	public Error login(UserBean user, Role role) {
		try {
			conn = DBConnection.getConnection();
			try (Statement stmt = conn.createStatement()) {
				String query = "select passwd from user_details where login_id=\'" + user.getLoginId() + "\'";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					return Error.USERNOTEXIST;
				}
				query = "select * from " + role.getTable() + " u join user_details d on u.user_id=d.user_id where login_id=\'" + user.getLoginId() + "\'";
				rs = stmt.executeQuery(query);
				if (!rs.next()) {
					return Error.WRONGROLE;
				}
				if (!user.getPasswd().equals(rs.getString("passwd"))) {
					return Error.INCORRECTPASSWORD;
				}
			}
		} catch (SQLException e) {
			return Error.DATABASE;
		}
		
		return Error.SUCCESS;
	}

}
