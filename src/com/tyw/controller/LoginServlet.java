package com.tyw.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tyw.bean.UserBean;
import com.tyw.dao.UserDAO;
import com.tyw.daoimpl.UserDAOImpl;
import com.tyw.enums.Error;
import com.tyw.enums.Role;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGEXPASSWD = "^[\\p{Graph}]{8,50}$";
	private static final String REGEXUID = "^[\\p{Alnum}]{8,50}$";

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId, passwd, role;
		String[] toReturn = new String[2];
		Error result = null;
		loginId = request.getParameter("login_id");
		passwd = request.getParameter("passwd");
		role = request.getParameter("role");
		String valid = validate(loginId, passwd);
		if (valid == "") {
			UserDAO user = new UserDAOImpl();
			UserBean bean = new UserBean();
			bean.setLoginId(loginId);
			bean.setPasswd(passwd);
			switch(role) {
			case "employee":
				result = user.login(bean, Role.EMPLOYEE);
				break;
			case "customer":
				result = user.login(bean, Role.CUSTOMER);
				break;
			}
			if (result != Error.SUCCESS) {
				toReturn[0] = "ERROR";
				toReturn[1] = result.getDescription();
			} else {
				toReturn[0] = "SUCCESS";
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUser", bean);
				session.setAttribute("role", role);
				Cookie cookie = new Cookie("uname", bean.getFname());
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
			}
//				toReturn[1] = result;
		} else {
			toReturn[0] = "ERROR";
			toReturn[1] = valid;
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(toReturn));
	}

	private String validate(String loginId, String passwd) {
		Pattern pattern = Pattern.compile(REGEXUID);
		if (!pattern.matcher(loginId).matches())
			return "Invalid user name";
		pattern = Pattern.compile(REGEXPASSWD);
		if (!pattern.matcher(passwd).matches())
			return "Invalid password";
		return "";
	}

}
