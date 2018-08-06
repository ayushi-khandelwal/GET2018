package ds_Assignment_2.Q2_InfixToPostfix;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class InfixToPostfixJUnitTest {

	InfixToPostfix infixToPostfix = new InfixToPostfix();
	
	@Test
	public void test_WhenOperandsAreIntegers_ReturnValidOutput() {
		String actualExpression = "( 1 + ( 2 * 3 ) )";
		String expectedExpression = "1 2 3 * +";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}

	@Test
	public void test_WhenOperandsAreCapitalCharacters_ReturnValidOutput() {
		String actualExpression = "A * ( B + C ) / D";
		String expectedExpression = "A B C + * D /";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}

	@Test
	public void test_WhenReturnValidOutput() {
		String actualExpression = "A + ( 2 * C - ( D / E - F ) * G ) * H";
		String expectedExpression = "A 2 C * D E / F - G * - H * +";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}

	@Test
	public void test_WhenOperandsAreSmallCharacters_ReturnValidOutput() {
		String actualExpression = "a * ( b + c ) / d";
		String expectedExpression = "a b c + * d /";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}

	@Test
	public void test_WhenOperandsAreBooleanOperators_ReturnValidOutput() {
		String actualExpression = "( a || b ) == ( c && d )";
		String expectedExpression = "a b || c d && ==";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}

	@Test
	public void test_WhenOperandsAreRelationalOperators_ReturnValidOutt() {
		String actualExpression = "a < ( b != c ) == ( d <= e )";
		String expectedExpression = "a b c != < d e <= ==";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}
	
	@Test
	public void test_WhenOperandsAreRandomOperators_ReturnValidOutt() {
		String actualExpression = "a + b < c / d && e == f";
		String expectedExpression = "a b + c d / e f == && <";
		assertEquals(expectedExpression, infixToPostfix.conversion(actualExpression));
	}
}
