package DBMS.DBMS_Session_5.assignment_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DBMS.DBMS_Session_5.jdbcConnection.JDBCConnection;

/**
 * Class containing method to retriev information of orders from user Id
 * Created on August 20, 2018
 */
public class OrderDetails {
	private Connection connection;
	
	/**
	 * Method to get the Orders details of the user given
	 * @param user Id as integer
	 */
	public List<OrdersDetailsPOJO> getOrderDetailsOfUser(int userId) throws SQLException {
		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root", "root");
		String queryToGetOrderDetails = "SELECT Order_Id, Order_Date, Order_Amount"
				+ " FROM Orders WHERE (User_Id="+userId+" AND Order_Status LIKE \"%shipped%\") ORDER BY Order_Date DESC";
		PreparedStatement preparedStatement = connection.prepareStatement(queryToGetOrderDetails);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			resultSet.previous();
			while(resultSet.next()) {
				OrdersDetailsPOJO.addToResultList(new OrdersDetailsPOJO(resultSet.getString("Order_Id"),
					resultSet.getString("Order_Date"),resultSet.getString("Order_Amount")));
			}
		} else {
			System.out.println("No Orders information for this User !\n");
		}
		connection.close();
		return OrdersDetailsPOJO.getResultList();
	}
}
