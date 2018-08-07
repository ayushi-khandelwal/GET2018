package ds_Assignment_2.Q5_nestedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class ListJUnitTest {
	
ListOLists listImplementation = new ListOLists();
    
    @Before
    public void init() {
        
        listImplementation.addCustomList(new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 12, 3, 4})));
        listImplementation.addCustomList(new ArrayList<Integer>(Arrays.asList(new Integer[] {12, 7, 3, 24})));
        listImplementation.addCustomList(new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 2, 9, 5})));
    }
    
    @Test
    public void test_LargestValue() {
        assertEquals(24, listImplementation.largestValue());
    }

    @Test
    public void test_Search_IfElementIsFound_ReturnTrue() {
        assertEquals(true, listImplementation.search(5));
        assertEquals(true, listImplementation.search(2));
    }

    @Test
    public void test_Search_IfElementIsNotFound_ReturnFalse() {
        assertEquals(false, listImplementation.search(10));
        assertEquals(false, listImplementation.search(29));
    }

    @Test
    public void test_Sum() {
        assertEquals(86, listImplementation.sum());
    }
}
