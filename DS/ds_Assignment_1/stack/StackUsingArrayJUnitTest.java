package ds_Assignment_1.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingArrayJUnitTest {

	StackUsingArray stack = new StackUsingArray(3);

	@Test
	public void test_Push_WhenElementIsPushed_ReturnTrue() {
		assertEquals(true, stack.push(1));
		assertEquals(true, stack.push(2));
		assertEquals(true, stack.push(3));
	}

	@Test
	public void test_Pop_WhenStackHasElements_ReturnPoppedElements() {
		assertEquals(true, stack.push(1));
		assertEquals(true, stack.push(3));
		assertEquals(true, stack.push(4));
		assertEquals(4, stack.pop());
		assertEquals(3, stack.pop());
	}

	@Test
	public void test_Pop_WhenStackIsEmpty_ReturnNegativeValue() {
		assertEquals(-1, stack.pop());
	}
	
	@Test
	public void test_Peek_WhenStackHasElements_ReturnPeek() {
		assertEquals(true, stack.push(2));
		assertEquals(2, stack.peek());
	}

	@Test(expected = AssertionError.class)
	public void test_Peek_WhenStackIsEmpty_ThrowAssertionError() {
		assertEquals("Stack underflow", stack.peek());
	}

	@Test
	public void test_isEmpty_WhenStackIsEmpty_ReturnTrue() {
		assertEquals(true, stack.isEmpty());
	}

	@Test
	public void test_Peek_isEmpty_WhenStackIsNotEmpty_ReturnFalse() {
		assertEquals(true, stack.push(5));
		assertEquals(false, stack.isEmpty());
	}
	
	@Test(expected = AssertionError.class)
	public void test_WhenAllOperationsPerformed() {
		assertEquals(true, stack.push(1));
		assertEquals(true, stack.push(3));
		assertEquals(3, stack.pop());
		assertEquals(true, stack.push(5));
		assertEquals(5, stack.peek());
		assertEquals(false, stack.isEmpty());
		assertEquals(5, stack.pop());
		assertEquals(1, stack.pop());
		assertEquals("Stack underflow", stack.peek());
		assertEquals(-1, stack.pop());
	}

	@Test
	public void test_DisplayStack_WhenStackHasElements_ReturnStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int[] expectedArray = {1, 2, 3};
		assertArrayEquals(expectedArray, stack.displayStack());
	}
	
	@Test(expected = AssertionError.class)
	public void test_DisplayStack_WhenStackIsEmpty_ThrowAssertionError() {
		assertEquals("Stack underflow", stack.displayStack());
	}
}
