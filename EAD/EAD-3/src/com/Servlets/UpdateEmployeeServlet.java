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

public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connectionToDB = JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("hiddenId");
        try {
            PreparedStatement preparedStatement = connectionToDB.prepareStatement(SQL_Queries.getEmailId(email));
            out.print("<form action = 'SetEmployee' method='get'><table width=50% border=1 align=\"center\">");
            ResultSet resultSet = preparedStatement.executeQuery();
            out.println("<table align=\"center\" border=\"1\">");
            out.println("<tr>");
            out.println("<th><h2>Email</h2></th>");
            out.println("<th><h2>First Name</h2></th>");
            out.println("<th><h2>Last Name</h2></th>");
            out.println("<th><h2>Age</h2></th>");
            out.println("</tr>");
            
            while (resultSet.next()) {
                
                out.println("<tr>");
                out.println("<td><input name='email' value='" + resultSet.getString("employee_Email") + "' readonly/></td>");
                out.println("<td><input type='text' name='firstName' value='"+ resultSet.getString("employee_First_Name") + "'/></td>");
                out.println("<td><input type='text' name='lastName' value='"+ resultSet.getString("employee_Last_Name") + "'/></td>");
                out.println("<td><input type='number' name='age' value='" + resultSet.getString("employee_age") + "'/></td>");
                out.println("<tr><td><input type='submit' value='submit'/></td></tr>");
                out.println("</tr>");
            }
            
            out.print("</table></form>");
            out.println("<p align=\"center\"><a href='home.html'>Back</a></p>");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            out.close();
            try {
                connectionToDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
