import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SparseJUnitTest {
	SparseMatrix sparseMatrix = new SparseMatrix();
	
	@Test
	public void test_transpose_WhenReturnValidOutput() {
		int[][] expectedMatrix = new int[][] {{0, 2, 0}, {0, 1, 3}, {5, 0, 0}};
		int[][] actualMatrix = sparseMatrix.transpose(new int[][] {{0, 0, 5}, {2, 1, 0}, {0, 3, 0}});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}

	@Test(expected = AssertionError.class)
	public void test_transpose_WhenEmptyArrayIsPassed_ReturnAssertionError() {
		int[][] expectedMatrix = new int[][] {};
		int[][] actualMatrix = sparseMatrix.transpose(new int[][] {});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}
	
	@Test
	public void test_Symmetry_WhenSymmetricMatrixIsPassed_ReturnTrue() {
		assertEquals(true, sparseMatrix.symmetry(new int[][] {{0, 2, 0}, {2, 1, 0}, {0, 0, 0}}));
	}

	@Test
	public void test_Symmetry_WhenSymmetricMatrixIsNotPassed_ReturnFalse() {
		assertEquals(false, sparseMatrix.symmetry(new int[][] {{0, 2, 1}, {2, 1, 0}, {0, 0, 0}}));
	}

	@Test
	public void test_Symmetry_WhenEmptyArrayIsPassed_ReturnAssertionError() {
		assertEquals(false, sparseMatrix.symmetry(new int[][] {}));
	}
	
	@Test
	public void test_Addition_WhenReturnsValidOutput() {
		int[][] expectedMatrix = new int[][] {{0,2,5}, {6,1,0}, {0,3,1}};
		int[][] actualMatrix = sparseMatrix.addition(new int[][] {{0,0,5}, {2,1,0}, {0,3,0}}, new int[][] {{0,2,0}, {4,0,0}, {0,0,1}});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}
	
	@Test(expected = AssertionError.class)
	public void test_Addition_WhenEmptyArrayIsPassed_ThrowAssertionError() {
		int[][] expectedMatrix = new int[][] {};
		int[][] actualMatrix = sparseMatrix.addition(new int[][] {}, new int[][] {});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}

	@Test(expected = AssertionError.class)
	public void test_Addition_WhenBothMatrixHaveDifferentSizes_ThrowAssertionError() {
		int[][] expectedMatrix = new int[][] {{0,2,5}, {6,1,0}, {0,3,0}};
		int[][] actualMatrix = sparseMatrix.addition(new int[][] {{0,0,5}, {2,1,0}, {0,3,0}}, new int[][] {{0,2,0}, {4,0,0}});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}

	@Test
	public void test_Multiply_WhenWhenReturnsValidOutput() {
		int[][] expectedMatrix = new int[][] {{0,0,5}, {4,4,0}, {12,0,0}};
		int[][] actualMatrix = sparseMatrix.multiply(new int[][] {{0,0,5}, {2,1,0}, {0,3,0}}, new int[][] {{0,2,0}, {4,0,0}, {0,0,1}});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}

	@Test(expected = AssertionError.class)
	public void test_Multiply_WhenEmptyArrayIsPassed_ThrowAssertionError() {
		int[][] expectedMatrix = new int[][] {};
		int[][] actualMatrix = sparseMatrix.multiply(new int[][] {}, new int[][] {});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}

	@Test(expected = AssertionError.class)
	public void test_Multiply_WhenBothMatrixHaveDifferentSizes_ThrowAssertionError() {
		int[][] expectedMatrix = new int[][] {};
		int[][] actualMatrix = sparseMatrix.multiply(new int[][] {{0,0,5}, {2,1,0}, {0,3,0}}, new int[][] {{0,2,0}, {4,0,0}});
		assertArrayEquals(expectedMatrix, actualMatrix);
	}
}
