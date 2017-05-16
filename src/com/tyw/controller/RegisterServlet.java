package com.tyw.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tyw.dao.CustomerDAO;
import com.tyw.daoimpl.CustomerDAOImpl;
import com.tyw.enums.Error;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGEXPASSWD = "^[\\p{Graph}]{8,}$";
	private static final String REGEXUID = "^[\\p{Alnum}]{8,}$";

    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid, passwd;
		String[] toReturn = new String[2];
		uid = request.getParameter("uid");
		passwd = request.getParameter("passwd");
		String valid = validate(uid, passwd);
		if (valid == "") {
			CustomerDAO cust = new CustomerDAOImpl();
//			String result = cust.login1(uid, passwd);
			Error result = cust.login(uid, passwd);
			if (result != Error.SUCCESS) {
				toReturn[0] = "ERROR";
				toReturn[1] = result.getDescription();
			} else {
				toReturn[0] = "SUCCESS";
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

	private String validate(String uid, String passwd) {
		Pattern pattern = Pattern.compile(REGEXUID);
		if (!pattern.matcher(uid).matches())
			return "Invalid user name";
		pattern = Pattern.compile(REGEXPASSWD);
		if (!pattern.matcher(passwd).matches())
			return "Invalid password";
		return "";
	}

}
