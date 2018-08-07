package ds_Assignment_2.Q1_PostfixEvaluator;

import static org.junit.Assert.*;
import org.junit.Test;

public class PostfixEvaluatorJUnitTest {

	PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
	
	@Test
	public void test_WhenEvaluate_ReturnValidOutput() {
		String actualExpression = "1 2 3 * + 4 -";
		assertEquals(3, Integer.parseInt(postfixEvaluator.evaluate(actualExpression)));
	}

	@Test
	public void test_WhenEvaluate_ReturnNegativeValue() {
		String actualExpression = "2 3 1 * + 9 -";
		assertEquals(-4, Integer.parseInt(postfixEvaluator.evaluate(actualExpression)));
	}

	@Test
	public void test_WhenEvaluateOnPrferenceBasis_ReturnValidOutput() {
		String actualExpression = "100 200 + 2 / 5 * 7 +";
		assertEquals(757, Integer.parseInt(postfixEvaluator.evaluate(actualExpression)));
	}
    
	@Test
	public void test_WhenExtraOperatorRemainsInStack_ReturnNull() {
		String actualExpression = "1 2 3 * + -";
		assertEquals(null, postfixEvaluator.evaluate(actualExpression));
	}

	@Test
	public void test_WhenExtraOperandRemainInStack_ReturnNull() {
		String actualExpression = "1 2 3 * + 4";
		assertEquals(null, postfixEvaluator.evaluate(actualExpression));
	}
}
