package ds_Assignment_1.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingLinkedListJUnitTest {

	StackUsingLinkedList stack = new StackUsingLinkedList();

	@Test
	public void test_Push_WhenElementIsPushed_ReturnTrue() {
		assertEquals(true, stack.push(1));
	}
	
}
