package DBMS_Session_5.assignment_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DBMS_Session_5.jdbcConnection.JDBCConnection;

/**
 * Class containing method to retrieve information of orders from user Id
 */
public class OrdersUtil {
	private Connection connection;
	private List<OrdersUtilPOJO> orderList;
	/**
	 * Method to get the Orders details of the user given
	 * @param user Id as integer
	 */
	public List<OrdersUtilPOJO> getOrderDetailsOfUser(int userId) throws SQLException {
		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root", "pass123");
		String queryToGetOrderDetails = "SELECT Orders.User_Id, Order_Status.Order_Id, Orders.Order_Date, Orders.Order_Amount "
                        				+ "FROM Orders INNER JOIN Order_Status ON Orders.Order_Id = Order_Status.Order_Id "
                        				+ "WHERE (Orders.User_Id = " + userId + " "
                        				        + "AND Order_Status.OrderStatus LIKE \"%shipped%\") "
                        		        + "ORDER BY Orders.Order_Date DESC";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetOrderDetails);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultSet.previous();
				while(resultSet.next()) {
					OrdersUtilPOJO.addToResultList(new OrdersUtilPOJO(resultSet.getString("User_Id"), 
											resultSet.getString("Order_Id"),
											resultSet.getString("Order_Date"),
											resultSet.getString("Order_Amount")));
				}
			} else {
			    System.out.println("No Orders information for this User !\n");
			}
		}
		catch(SQLException se) {
			se.getMessage();
		}
		catch(Exception e) {
			e.getMessage();
		}
		connection.close();
		orderList = OrdersUtilPOJO.getResultList();
		return orderList;
	}
}
