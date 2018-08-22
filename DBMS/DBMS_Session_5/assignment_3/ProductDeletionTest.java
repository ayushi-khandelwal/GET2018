package DBMS_Session_5.assignment_3;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

/**
 * Class containing test methods 
 */
public class ProductDeletionTest {

	/**
	 * Method to test deleteProductsNotPurchased method Success scenario
	 * @throws SQLException 
	 */
	@Test
	public void testDeleteProductsNotPurchased_Success() throws SQLException  {
		ProductDeletion productDeletion = new ProductDeletion();
		int result = productDeletion.deleteProductsNotPurchased();
		
		assertEquals(21, result);
	}
	
	/**
	 * Method to test deleteProductsNotPurchased method Failure scenario
	 * @throws SQLException 
	 */
	@Test
	public void testDeleteProductsNotPurchased_Failure() throws SQLException  {
		ProductDeletion productDeletion = new ProductDeletion();
		int result = productDeletion.deleteProductsNotPurchased();
		
		assertNotEquals(0, result);
	}

}
