import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class MathProblemJUnitTest {

	MathProblem mathProblem = new MathProblem();
	
	@Test
	public void LCMtestFirst() {	//Assuming x and y are positive integers
		assertEquals(24, mathProblem.LCM(6, 8));
	}
	
	@Test
	public void LCMtestSecond() {
		assertEquals(9, mathProblem.LCM(1, 9));
	}

	@Test
	public void LCMtestThird() {
		assertEquals(8, mathProblem.LCM(4, 8));
	}
	
	@Test
	public void LCMtestFourth() {
		assertEquals(0, mathProblem.LCM(0, 11));
	}

	
	@Test
	public void HCFtestFirst() {	//Assuming x and y are positive integers
		assertEquals(6, mathProblem.HCF(18, 24));
	}
	
	@Test
	public void HCFtestSecond() {
		assertEquals(4, mathProblem.HCF(4, 8));
	}

	@Test
	public void HCFtestThird() {
		assertEquals(1, mathProblem.HCF(9, 22));
	}
	
	@Test
	public void HCFtestFourth() {
		assertEquals(11, mathProblem.HCF(0, 11));
	}

	@Test
	public void HCFtestFifth() {
		assertEquals(1, mathProblem.HCF(1, 11));
	}

	
}
