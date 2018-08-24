package DBMS_Session_5.assignment_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing results of OrderDetails
 */
public class OrdersUtilPOJO {
	private static List<OrdersUtilPOJO> resultList = new ArrayList<OrdersUtilPOJO>();
	
    	private String userId;
	private String orderId;
	private String orderDate;
	private String orderAmount;
	
	public OrdersUtilPOJO (String userId, String orderId, String orderDate, String orderAmount) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.userId = userId;
	}

	public static List<OrdersUtilPOJO> getResultList() {
		return resultList;
	}

	public static void addToResultList(OrdersUtilPOJO result) {
		resultList.add(result);
	}

	public String getUserId() {
		return userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public static void emptyList() {
       		resultList.removeAll(resultList);
    	}
}
