package DBMS_Session_5.assignment_2;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

/**
 * Class containing test methods
 */
public class BatchInsertionTest {

	/**
	 * Method to test insertBatchIntoImageTable method Success Scenario
	 * @throws SQL Exception
	 */
	@Test
	public void testInsertBatchIntoImageTable_Success() throws SQLException {
		BatchInsertion batchInsertion = new BatchInsertion();
		int result = batchInsertion.insertBatchIntoImageTable();
		
		assertEquals(7, result);
	}
	
	/**
	 * Method to test insertBatchIntoImageTable method Failure Scenario
	 * @throws SQL Exception
	 */
	@Test
	public void testInsertBatchIntoImageTable_Failure() throws SQLException {
		BatchInsertion batchInsertion = new BatchInsertion();
		int result = batchInsertion.insertBatchIntoImageTable();
		
		assertNotEquals(6, result);
	}
	
}
