package ds_Assignment_2.PostfixEvaluator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorJUnitTest {

	PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
	
	@Test
	public void test_WhenReturnValidOutput() {
		String actualExpression = "1 2 3 * + 4 -";
		assertEquals(3, postfixEvaluator.evaluate(actualExpression));
	}

	@Test
	public void test_WhenExtraOperatorRemainsInStack_ReturnNegativeValue() {
		String actualExpression = "1 2 3 * + -";
		assertEquals(-1, postfixEvaluator.evaluate(actualExpression));
	}

	@Test
	public void test_WhenExtraOperandRemainInStack_ReturnNegativeValue() {
		String actualExpression = "1 2 3 * + 4";
		assertEquals(-1, postfixEvaluator.evaluate(actualExpression));
	}

}
