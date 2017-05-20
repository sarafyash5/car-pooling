package com.tyw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tyw.bean.CustomerBean;
import com.tyw.dao.CustomerDAO;
import com.tyw.daoimpl.CustomerDAOImpl;
import com.tyw.enums.Error;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] toReturn = new String[2];
		CustomerBean bean = new CustomerBean();
		CustomerDAO cust = new CustomerDAOImpl();
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("lname"));
		bean.setPhone(Long.parseLong((request.getParameter("phone"))));
		bean.setEmail(request.getParameter("email"));
		bean.setLicenseNo(request.getParameter("license"));
		bean.setPostalAddress(request.getParameter("address"));
		bean.setLoginId(request.getParameter("login_id"));
		bean.setPasswd(request.getParameter("passwd"));
		Error result = cust.register(bean);
		if (result != Error.SUCCESS) {
			toReturn[0] = "ERROR";
			toReturn[1] = result.getDescription();
		} else {
			toReturn[0] = "SUCCESS";
			HttpSession session = request.getSession(true);
			session.setAttribute("currentUser", bean);
			session.setAttribute("role", "customer");
			Cookie cookie = new Cookie("uname", bean.getFname());
			cookie.setPath("/");
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}
		// toReturn[1] = result;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(toReturn));
	}

}
