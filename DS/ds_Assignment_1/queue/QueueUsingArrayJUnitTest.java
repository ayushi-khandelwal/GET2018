package ds_Assignment_1.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingArrayJUnitTest {

	QueueUsingArray queue = new QueueUsingArray(3);

	@Test
	public void test_add_WhenElementIsadded_ReturnTrue() {
		assertEquals(true, queue.add(1));
	}
	
	@Test
	public void test_add_WhenQueueIsFull_ReturnFalse() {
			assertEquals(true, queue.add(1));
			assertEquals(true, queue.add(2));
			assertEquals(true, queue.add(3));
			assertEquals(false, queue.add(4));
	}

	@Test
	public void test_delete_WhenqueueHasElements_ReturnTrue() {
		queue.add(2);
		assertEquals(true, queue.delete());
	}
	
	@Test
	public void test_delete_WhenqueueIsEmpty_ReturnFalse() {
		assertEquals(false, queue.delete());
	}

	
}
