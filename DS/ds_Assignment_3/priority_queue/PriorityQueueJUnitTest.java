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
 
    @Test(expected = AssertionError.class)
    public void test_enqueue_WhenItemIsNull_ThrowAssertionError() {
        assertEquals(AssertionError.class, queue.enqueue("", 2));
    }
     
    @Test(expected = AssertionError.class)
    public void test_enqueue_WhenPriorityIsNegative_ThrowAssertionError() {
        assertEquals(true, queue.enqueue("Item1", 0));
        assertEquals(AssertionError.class, queue.enqueue("Item2", -1));
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
    public void test_getHighestPriority_WhenTwoOrMoreItemsHavingSamePriority_ReturnPriorityOnBasisOfFirstComeFirstServe() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 10));
        assertEquals(true, queue.enqueue("Item3", 10));
        assertEquals(true, queue.enqueue("Item4", 1));
        assertEquals(10, queue.getHighestPriority());
        assertEquals("Item2", queue.getHighestPriorityItem());
    }

    @Test(expected = AssertionError.class)
    public void test_getHighestPriority_WhenQueueIsEmpty_ThrowAssertionError() {
        assertEquals(true, queue.isEmpty());
        queue.getHighestPriority();
    }

    @Test(expected = AssertionError.class)
    public void test_getHighestPriorityItem_WhenQueueIsEmpty_ThrowAssertionError() {
        assertEquals(true, queue.isEmpty());
        queue.getHighestPriorityItem();
    } 

    @Test
    public void test_dequeueHighestPriority_WhenAllItemsHavingDifferentPriority_ReturnItemOfHighestPriority() {
        assertEquals(true, queue.enqueue("Item1", 1));
        assertEquals(true, queue.enqueue("Item2", 10));
        assertEquals(true, queue.enqueue("Item3", 4));
        assertEquals(true, queue.enqueue("Item4", 6));
        assertEquals("Item2", queue.dequeueHighestPriorityItem());
        assertEquals("Item4", queue.dequeueHighestPriorityItem());
    }
 
    @Test(expected = AssertionError.class)
    public void test_dequeueHighestPriority_WhenQueueIsEmpty_ThrowAssertionError() {
        assertEquals(AssertionError.class, queue.dequeueHighestPriorityItem());
    }

    @Test
    public void test_checksIfQueueIsEmptyOrNot_WhenQueueIsEmpty_ReturnTrue() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void test_checksIfQueueIsEmptyOrNot_WhenQueueIsNotEmpty_ReturnFalse() {
        assertEquals(true, queue.enqueue("Item3", 5));
        assertEquals(true, queue.enqueue("Item4", 4));
        assertEquals(false, queue.isEmpty());
    }
}
