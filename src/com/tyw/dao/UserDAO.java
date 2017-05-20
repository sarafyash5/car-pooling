package com.tyw.dao;

import com.tyw.bean.UserBean;
import com.tyw.enums.Error;
import com.tyw.enums.Role;

public interface UserDAO {

	public Error login(UserBean user, Role role);

}
