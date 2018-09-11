package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Properties.Properties;


public class ConnectionHelper {

	public static Connection getConnection() {
		Connection conn=null;

		try {
			Class.forName(Properties.CLASS_PATH);
			conn = DriverManager.getConnection(Properties.DB_URL,Properties.USERNAME,Properties.PASSWORD);
		} 
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		}
		catch (SQLException e)
		{
			e.getMessage();
		}
		catch(Exception e) {
		    e.getMessage();
		}
	
		return conn;
	}

	public static void closeConection(Connection conn) throws AssertionError{
		try {
			if(conn != null) {
				conn.close();
			}
		}

		catch(SQLException se) {
			throw new AssertionError();
		}
	}
}

