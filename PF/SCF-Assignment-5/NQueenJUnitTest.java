import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenJUnitTest {
	NQueenProblem nQueenProblem = new NQueenProblem();
	
	@Test
	public void testFirst() {
		assertEquals(true, nQueenProblem.nQueen(new int [][] {
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0} }, 0, 4));
		
	}

	@Test
	public void testSecond() {
		assertEquals(true, nQueenProblem.nQueen(new int [][] {
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
