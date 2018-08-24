package DBMS_Session_5.assignment_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DBMS_Session_5.assignment_1.OrdersDetailsPOJO;
import DBMS_Session_5.jdbcConnection.JDBCConnection;

/**
 * Class containing method to delete products as mentioned
 */
public class ProductUtil {
	private Connection connection;
	/**
	 * Method deletes the Products which are not ordered from 1 year
	 * @return number of products status updated
	 */
	public int deleteProductsNotPurchased() throws SQLException {
		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root", "pass123");
		int result=0;
		String queryToDeleteProduct = 
		        "UPDATE Product SET Product.Product_Status = "Inactive" 
			WHERE Product_Id NOT IN (SELECT Order_Status.Product_Id 
                        FROM Order_Status 
                        LEFT JOIN Orders ON Order_Status.Order_Id = Orders.Order_Id 
                        WHERE DATEDIFF(now(), Orders.Order_Date) < 365);";	
		
		PreparedStatement psForDeleteProduct = connection.prepareStatement(queryToDeleteProduct);
		result = psForDeleteProduct.executeUpdate();
		return result;
	}
}
