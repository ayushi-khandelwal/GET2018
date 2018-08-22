package DBMS_Session_5.assignment_4;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

/**
 * Class containing test methods
 */
public class CategoriesInParentCategoryTest {

	/**
	 * Method to test getChildCategoryCount success scenario
	 * @throws SQLException
	 */
	@Test
	public void testGetChildCategoryCount_Success() throws SQLException {
		List<CategoriesInParentCategoryPOJO> list = new CategoriesInParentCategory().getChildCategoryCount();
		assertEquals(4, list.size());
	}
	
	/**
	 * Method to test getChildCategoryCount failure scenario
	 * @throws SQLException
	 */
	@Test
	public void testGetChildCategoryCount_Failure() throws SQLException {
		List<CategoriesInParentCategoryPOJO> list = new CategoriesInParentCategory().getChildCategoryCount();
		assertNotEquals(5, list.size());
	}

}
