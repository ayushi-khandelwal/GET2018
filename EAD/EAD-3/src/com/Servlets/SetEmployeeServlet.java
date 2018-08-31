package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.SQL_Queries;

public class SetEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "pass123");
        response.setContentType("text/html");
        
        
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Queries.updateDetail());
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.executeUpdate();
            
            out.print("<h3 align=\"center\">Successfully Updated the employee details...</h3>");
            out.print("<p align=\"center\"><a href='home.html'>Back</a></p>");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            out.close();
        }
    }
}
