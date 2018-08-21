package DBMS.DBMS_Session_5.assignment_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBMS.DBMS_Session_5.jdbcConnection.JDBCConnection;

/**
 * Class containing method to delete products as mentioned
 * Created on August 21, 2018
 */
public class ProductDeletion {
	private Connection connection;
	
	/**
	 * Method deletes the Products which are not ordered from 1 year
	 * @return number of products status updated
	 */
	public int deleteProductsNotPurchased() throws SQLException {
		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root", "root");
		int result=0;
		String queryToDeleteProduct = "UPDATE Product SET Product_Status='INACTIVE' "
				+ "WHERE Product_Id NOT IN (SELECT Products_In_Order.Product_Id FROM "
				+ "Products_In_Order LEFT JOIN Orders ON Products_In_Order.Order_Id = Orders.Order_Id "
				+ "WHERE DATEDIFF(now(),Orders.Order_Date)<365)";	
		
		PreparedStatement psForDeleteProduct = connection.prepareStatement(queryToDeleteProduct);
		result = psForDeleteProduct.executeUpdate();
		
		return result;
	}
}
