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
 * Servlet implementation class GetEmployeeDetail
 */
@SuppressWarnings("serial")
public class GetEmployeeFullDetails extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String email = request.getParameter("hiddenId");
        Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
        
        if(connection!=null) {
            String queryToGetEmployeeDetails = SQL_Queries.getEmployeeFullDetail();
           
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(queryToGetEmployeeDetails);
                preparedStatement.setString(1, email);
                
                ResultSet resultSet = preparedStatement.executeQuery();
                out.println("<table align=\"center\" border=\"1\">");
                out.println("<tr>");
                out.println("<th><h1>Email</h1></th>");
                out.println("<th><h1>FirstName</h1></th>");
                out.println("<th><h1>LastName</h1></th>");
                out.println("<th><h1>Age</h1></th>");
                out.println("</tr>");
                if(resultSet.next()) {
                    do {
                        out.println("<tr><br><br>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Email")+"</strong></td>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_First_Name")+"</strong></td>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Last_Name")+"</strong></td>");
                        out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_age")+"</strong></td>");
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
