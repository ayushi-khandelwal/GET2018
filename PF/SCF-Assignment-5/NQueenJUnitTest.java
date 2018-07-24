import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenJUnitTest {
	NQueenProblem nQueenProblem = new NQueenProblem();
	
	@Test
	public void test_WhenArraySizeIs4_WouldReturnSingleSolution() {
		int[][] board = nQueenProblem.nQueenSolution(new int[][] {{ 0,  0,  0,  0},
									 { 0,  0,  0,  0},
									  { 0,  0,  0,  0},
									  { 0,  0,  0,  0} }, 0, 4);
		assertArrayEquals(new int[][] {{ 0,  0,  1,  0},
						{ 1,  0,  0,  0},
					        { 0,  0,  0,  1},
					    	{ 0,  1,  0,  0} }, board);
	}

	@Test
	public void test_WhenArraySizeIs3_ThenArrayIsNotSameAsExpected() {
		int[][] board = nQueenProblem.nQueenSolution(new int[][] {{ 0,  0,  0 },
									  { 0,  0,  0 },
									  { 0,  0,  0 } }, 0, 3);
		assertNotSame(new int[][] {{ 0,  0,  1 },
					   { 1,  0,  0 },
					   { 0,  0,  0 } }, board);
		
	}

	@Test
	public void test_WhenArraySizeIs8_ThenArrayIsSameAsExpected() {
		int[][] board = nQueenProblem.nQueenSolution(new int[][] {{ 1,  0,  0,  0,  0,  0,  0,  0},
									  { 0,  0,  0,  0,  0,  0,  1,  0},
									  { 0,  0,  0,  0,  1,  0,  0,  0},
									  { 0,  0,  0,  0,  0,  0,  0,  1},
									  { 0,  1,  0,  0,  0,  0,  0,  0},
									  { 0,  0,  0,  1,  0,  0,  0,  0},
									  { 0,  0,  0,  0,  0,  1,  0,  0},
									  { 0,  0,  1,  0,  0,  0,  0,  0} }, 0, 8);
		
		assertArrayEquals(board, nQueenProblem.nQueenSolution(new int [][] {
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0},
            { 0,  0,  0,  0, 0, 0,  0, 0} }, 0, 8));
		
	}

}
