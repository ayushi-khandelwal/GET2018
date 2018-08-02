package ds_Assignment_1.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingArrayJUnitTest {

	StackUsingArray stack = new StackUsingArray(3);

	@Test
	public void test_Push_WhenElementIsPushed_ReturnTrue() {
		assertEquals(true, stack.push(1));
	}
	
	@Test
	public void test_Push_WhenStackIsFull_ReturnFalse() {
			assertEquals(true, stack.push(1));
			assertEquals(true, stack.push(2));
			assertEquals(true, stack.push(3));
			assertEquals(false, stack.push(4));
	}

	@Test
	public void test_Pop_WhenStackHasElements_ReturnTrue() {
		stack.push(2);
		assertEquals(true, stack.pop());
	}
	
	@Test
	public void test_Pop_WhenStackIsEmpty_ReturnFalse() {
		assertEquals(false, stack.pop());
	}
	
		
	@Test
	public void test_Peek_WhenStackHasElements_ReturnPeek() {
		stack.push(2);
		assertEquals(2, stack.peek());
	}

	@Test(expected = AssertionError.class)
	public void test_Peek_WhenStackIsEmpty_ThrowAssertionError() {
			assertEquals("Stack underflow", stack.peek());
	}

	@Test
	public void test_DisplayStack_WhenStackHasElements_ReturnStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int[] array = {1, 2, 3};
		assertArrayEquals(array, stack.displayStack());
	}
	
	@Test
	public void test_DisplayStack_WhenStackIsEmpty_ThrowAssertionError() {
		try{
			stack.displayStack();
		} catch(AssertionError e){
			assertEquals("Stack underflow", e.getMessage());
		}
	}
	
	

}
