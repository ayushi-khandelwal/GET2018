import static org.junit.Assert.*;
import org.junit.Test;

public class NQueenJUnitTest {
	NQueenProblem nQueenProblem = new NQueenProblem();
	
	@Test
	public void test_WhenArraySizeIs4_WouldReturnSingleSolution() {
		int[][] board = nQueenProblem.nQueenSolution(4);
		assertArrayEquals(new int[][] {{ 0,  0,  1,  0},
						{ 1,  0,  0,  0},
					       { 0,  0,  0,  1},
					       { 0,  1,  0,  0} }, board);
		
	}

	@Test(expected = AssertionError.class)
	public void test_WhenArraySizeIs3_ThenArrayIsNotSameAsExpected() {
		int[][] board = nQueenProblem.nQueenSolution( 3);
		assertArrayEquals(new int[][] {{0, 0, 0},
						{0, 0, 0}, 
						{0, 0, 0}}, board);
	}

	@Test
	public void test_WhenArraySizeIs8() {
		int[][] board = nQueenProblem.nQueenSolution( 8);
		assertArrayEquals(new int [][] {
				  { 1,  0,  0,  0,  0,  0,  0,  0},
				  { 0,  0,  0,  0,  0,  0,  1,  0},
				  { 0,  0,  0,  0,  1,  0,  0,  0},
				  { 0,  0,  0,  0,  0,  0,  0,  1},
				  { 0,  1,  0,  0,  0,  0,  0,  0},
				  { 0,  0,  0,  1,  0,  0,  0,  0},
				  { 0,  0,  0,  0,  0,  1,  0,  0},
				  { 0,  0,  1,  0,  0,  0,  0,  0} }, board);
		
	}
}
