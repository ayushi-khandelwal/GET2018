package DBMS.DBMS_Session_5.assignment_1;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

/**
 * Class containing Junit Test methods 
 * Created on August 21, 2018
 */
public class OrderDetailsTest {

	/**
	 * Method to test getOrderDetailsOfUser methods success scenario
	 * @throws SQLException 
	 */
	@Test
	public void testGetOrderDetailsOfUser_Success() throws SQLException {
		List<OrdersDetailsPOJO> list = new OrderDetails().getOrderDetailsOfUser(9);
		assertEquals(1,list.size());
	}
	
	/**
	 * Method to test getOrderDetailsOfUser methods Failure scenario
	 * @throws SQLException 
	 */
	@Test
	public void testGetOrderDetailsOfUser_Failure() throws SQLException {
		List<OrdersDetailsPOJO> list = new OrderDetails().getOrderDetailsOfUser(0);
		assertNotEquals(2,list.size());
	}

}
