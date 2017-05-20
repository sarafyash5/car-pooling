package com.tyw.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tyw.dao.CustomerDAO;
import com.tyw.daoimpl.CustomerDAOImpl;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGEXPASSWD = "^[\\p{Alnum}!@#$%^&*_?]{8,50}$";
	private static final String REGEXUID = "^[\\p{Alnum}]{8,50}$";
	private static final String REGEXNAME = "^[\\p{Alpha}]{1,50}$";
	private static final String REGEXLICENSE = "^(?:[\\p{Alnum}]{10})?$";
	private static final String REGEXPHONE = "^[\\p{Digit}]{10}$";
	private static final String REGEXEMAIL = "^[\\p{Alnum}.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([\\p{Alnum}\\-]+\\.)+[\\p{Alpha}]{2,}))$";
	private static final String REGEXADDRESS = "^[\\p{Graph}]{0,255}$";

	public ValidateServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDAO cust = new CustomerDAOImpl();
		String[] toReturn = new String[2];
		Enumeration<String> params = request.getParameterNames();
		toReturn[0] = "SUCCESS";
		outer: while (params.hasMoreElements()) {
			String param = params.nextElement();
			String str = request.getParameter(param);
			switch (param) {
			case "fname":
				if (!validate(str, REGEXNAME)) {
					toReturn[1] = "Invalid First Name";
					break outer;
				}
				break;
			case "lname":
				if (!validate(str, REGEXNAME)) {
					toReturn[1] = "Invalid Last Name";
					break outer;
				}
				break;
			case "address":
				if (!validate(str, REGEXADDRESS)) {
					toReturn[1] = "Invalid Address";
					break outer;
				}
				break;
			case "passwd":
				if (!validate(str, REGEXPASSWD)) {
					toReturn[1] = "Invalid Password";
					break outer;
				}
				break;
			case "login_id":
				if (!validate(str, REGEXUID)) {
					toReturn[1] = "Invalid User ID";
					break outer;
				}
				if(cust.checkIfExists(param, str)) {
					toReturn[1] = "The User ID already exists";
					break outer;
				}
				break;
			case "email":
				if (!validate(str, REGEXEMAIL)) {
					toReturn[1] = "Invalid Email ID";
					break outer;
				}
				if(cust.checkIfExists(param, str)) {
					toReturn[1] = "The Email ID already exists";
					break outer;
				}
				break;
			case "phone":
				if (!validate(str, REGEXPHONE)) {
					toReturn[1] = "Invalid Phone Number";
					break outer;
				}
				if(cust.checkIfExists(param, str)) {
					toReturn[1] = "The Phone Number already exists";
					break outer;
				}
				break;
			case "license":
				if (!validate(str, REGEXLICENSE)) {
					toReturn[1] = "Invalid License Number";
					break outer;
				}
				if(cust.checkIfExists(param, str)) {
					toReturn[1] = "The License Number already exists";
					break outer;
				}
				break;
			}
		}
		if (toReturn[1] != null) {
			toReturn[0] = "ERROR";
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(toReturn));
	}

	private boolean validate(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(str).matches();
	}

}