package com.Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Facade.Facade;

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = Facade.getInstance();
		try {
			facade.updateUserInfo(request.getParameter("firstName"), request.getParameter("lastName"),
					Date.valueOf(request.getParameter("dateofBirth")),
					Integer.parseInt(request.getParameter("contactNo")), Integer.parseInt(request.getParameter("id")));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
