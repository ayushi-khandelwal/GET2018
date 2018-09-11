package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.SQL_Queries;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@SuppressWarnings("serial")
public class AddEmployeeDetails extends HttpServlet {
	
	/**
	 * method to add employee details to database
	 * @throws IOException 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
		if(connection!=null) {
			String queryToAddEmployee = SQL_Queries.addEmployee();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToAddEmployee);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
				preparedStatement.setInt(4, age);
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					 out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
					 
					 RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.html");
					 requestDispatcher.include(request, response);
				} else {
					response.sendRedirect("error.html");
				}
				connection.close();
			} catch (SQLException e) {
				 out.println("<h2 style=\"color:red;text-align:center;\">Employee Already Present !</h2>");
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("addemployee.html");
				 requestDispatcher.include(request, response);
				 
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error.html");
		}
	}

}
