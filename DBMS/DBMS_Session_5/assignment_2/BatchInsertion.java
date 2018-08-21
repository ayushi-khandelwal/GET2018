package DBMS.DBMS_Session_5.assignment_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBMS.DBMS_Session_5.jdbcConnection.JDBCConnection;

/**
 * Class containing method to insert batch records
 * Created on August 21, 2018
 */
public class BatchInsertion {
	private Connection connection;
	
	/**
	 * Method to insert Batch data to the image table
	 * @return count of record inserted
	 */
	public int insertBatchIntoImageTable() throws SQLException {
		connection=JDBCConnection.getDatabaseConnection("StoreFront", "root", "root");
		int result=0;
		String queryForImageBatchInsertion = "INSERT INTO IMAGE(Product_Id,Image_URL) VALUES (?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryForImageBatchInsertion);
			connection.setAutoCommit(false);
			for(int i=1; i<=7; i++) {
				preparedStatement.setInt(1,i);
				preparedStatement.setString(2,"urlImage"+23450+i);
				preparedStatement.addBatch();
			}
			int[] numberOfRowsAffected = preparedStatement.executeBatch();
			result=numberOfRowsAffected.length;
			connection.commit();
		} catch (SQLException se) {
			System.out.println("SQL Exception occurred !");
			connection.rollback();
		}
		connection.close();
		return result;
	}
}
