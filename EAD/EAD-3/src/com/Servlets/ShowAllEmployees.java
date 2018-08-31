package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.SQL_Queries;

/**
 * Servlet implementation class ShowAllEmployees
 */
@SuppressWarnings("serial")
public class ShowAllEmployees extends HttpServlet {
	
	/**
	 * method to show all employee details
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		if(connection!=null) {
			String queryToGetAllEmployees = SQL_Queries.showAllEmployees();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToGetAllEmployees);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				out.println("<table align=\"center\" border=\"1\">");
				out.println("<tr>");
				out.println("<th><h2>Email</h2></th>");
				out.println("<th><h2>First Name</h2></th>");
                out.println("<th><h2>Last Name</h2></th>");
				out.println("<th><h2>Age</h2></th>");
				out.println("</tr>");
				if(resultSet .next()) {
					do {
						out.println("<tr>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Email")+"</strong></td>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_First_Name")+"</strong></td>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Last_Name")+"</strong></td>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_age")+"</strong></td>");
						out.println("<td align=\"center\"><form action='UpdateEmployee' method='get'>"
	                               + "<input type='hidden' name='hiddenId' value='" + resultSet.getString("employee_Email")
	                               + "'/><input type='submit' name='editEmployee' value='Edit Details'/></form></td>");
						out.println("</tr>");
					} while (resultSet.next());
				} else {
					out.println("<h2 style=\"color:black;text-align:center;\">No Employees In Database !</h2>");
				}
				out.println("</table>");
                out.println("<h2 align=\"center\"><a href=\"home.html\">Home</a></h2>");
                out.println("<h2 align=\"center\"><a href=\"searchemployee.html\">Back</a><hr></h2>");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error.html");
		}
	}

}
