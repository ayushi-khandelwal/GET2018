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
 * Servlet implementation class GetEmployeeDetails
 */
@SuppressWarnings("serial")
public class GetEmployeeDetails extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
		if(connection!=null) {
			String queryToGetEmployeeDetails = SQL_Queries.getEmployeeDetail();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToGetEmployeeDetails);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, name);
				String[] tokens = name.split(" ");
				if(tokens != null) {
                    preparedStatement.setString(3, tokens[0]);
                    preparedStatement.setString(4, tokens[1]);
				}
				
				ResultSet resultSet = preparedStatement.executeQuery();
				out.println("<table align=\"center\" border=\"1\">");
				out.println("<tr>");
				out.println("<th><h1>FirstName</h1></th>");
                out.println("<th><h1>LastName</h1></th>");
				out.println("</tr>");
				if(resultSet.next()) {
					do {
						out.println("<tr>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_First_Name")+"</strong></td>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Last_Name")+"</strong></td>");

						out.println("<td align=\"center\"><form action='GetEmployeeFullDetails' method='get'>"
	                               + "<input type='hidden' name='hiddenId' value='" + resultSet.getString("employee_Email")
	                               + "'/><input type='submit' name='getFullDetails' value='Get Full Details'/></form></td>");
						
						out.println("</tr>");
					} while (resultSet.next());
				} else {
					out.println("<h2 style=\"color:black;text-align:center;\">No Employee with the name entered !</h2>");
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
