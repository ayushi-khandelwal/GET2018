package ds_Assignment_1.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingLinkedListJUnitTest {
	QueueUsingLinkedList queue = new QueueUsingLinkedList();

	@Test
	public void test_enqueue_WhenElementIsEnqueued_ReturnTrue() {
		assertEquals(true, queue.enqueue(1));
		assertEquals(true, queue.enqueue(2));
		assertEquals(true, queue.enqueue(3));
		assertEquals(true, queue.enqueue(4));
	}

	@Test
	public void test_dequeue_WhenQueueHasElements_ReturnDequeuedElement() {
		assertEquals(true, queue.enqueue(2));
		assertEquals(true, queue.enqueue(3));
		assertEquals(true, queue.enqueue(4));
		assertEquals(2, queue.dequeue());
		assertEquals(true, queue.enqueue(5));
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
	}
	
	@Test
	public void test_dequeue_WhenqueueIsEmpty_ReturnFalse() {
		assertEquals(-1, queue.dequeue());
	}
	
	@Test
	public void test_isEmpty_WhenqueueIsEmpty_ReturnTrue() {
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	public void test_dequeue_WhenqueueIsNotEmpty_ReturnFalse() {
		assertEquals(true, queue.enqueue(2));
		assertEquals(true, queue.enqueue(3));
		assertEquals(false, queue.isEmpty());
	}
	
    @Test
    public void test_peek_WhenQueueHasElements_ReturnPeekValue() {
        assertEquals(true, queue.enqueue(3));
        assertEquals(true, queue.enqueue(2));
        assertEquals(3, queue.dequeue());
        assertEquals(true, queue.enqueue(4));
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.peek());
    }
	
	@Test
    public void test_WhenOpeartionsAreRandom() {
        assertEquals(true, queue.enqueue(3));
        assertEquals(true, queue.enqueue(2));
        assertEquals(true, queue.enqueue(5));
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(true, queue.enqueue(6));
        assertEquals(true, queue.enqueue(7));
    }
}
