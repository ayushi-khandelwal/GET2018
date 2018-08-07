package ds_Assignment_3.priority_queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueJUnitTest {

    PriorityQueue queue = new PriorityQueue();
    @Test
    public void test_enqueue() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 2));
        assertEquals(true, queue.enqueue("Item3", 3));
        assertEquals(true, queue.enqueue("Item4", 4));
    }
    
    @Test
    public void test_enqueue_WhenPriorityIsNegative_ReturnFalse() {
        assertEquals(true, queue.enqueue("Item1", 0));
        assertEquals(false, queue.enqueue("Item2", -1));
    }
    
    @Test
    public void test_getHighestPriority_WhenAllItemsHavingDifferentPriority_ReturnHighestPriority() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 10));
        assertEquals(true, queue.enqueue("Item3", 8));
        assertEquals(true, queue.enqueue("Item4", 4));
        assertEquals(10, queue.getHighestPriority());
        assertEquals("Item2", queue.getHighestPriorityItem());
    }

    @Test
    public void test_getHighestPriority_WhenTwoOrMoreItemsHavingSamePriority_ReturnOnBasisOfFCFS() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 10));
        assertEquals(true, queue.enqueue("Item3", 10));
        assertEquals(true, queue.enqueue("Item4", 1));
        assertEquals(10, queue.getHighestPriority());
        assertEquals("Item2", queue.getHighestPriorityItem());
    }

    @Test
    public void test_getHighestPriority_WhenQueueIsEmpty_ReturnNegativeValue() {
        assertEquals(-1, queue.getHighestPriority());
    }

    @Test
    public void test_dequeueHighestPriority_WhenAllItemsHavingDifferentPriority_ReturnItemOfHighestPriority() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 10));
        assertEquals(true, queue.enqueue("Item3", 5));
        assertEquals(true, queue.enqueue("Item4", 4));
        assertEquals("Item2", queue.dequeueHighestPriority());
        assertEquals("Item3", queue.dequeueHighestPriority());
    }

    @Test
    public void test_dequeueHighestPriority_WhenQueueIsEmpty_ReturnNull() {
        assertEquals(null, queue.dequeueHighestPriority());
    }
}
