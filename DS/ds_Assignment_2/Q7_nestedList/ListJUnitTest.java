package ds_Assignment_2.Q7_nestedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class ListJUnitTest {
	
ListOLists listOLists = new ListOLists();
    
    @Before
    public void init() {
        ArrayList<Integer> innerList11 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        ArrayList<Integer> innerList12 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8}));
        ArrayList<Integer> innerList21 = new ArrayList<Integer>(Arrays.asList(new Integer[] {9, 10, 11, 12}));
        ArrayList<Integer> innerList22 = new ArrayList<Integer>(Arrays.asList(new Integer[] {13, 14, 15, 16}));
        ArrayList<Integer> innerList31 = new ArrayList<Integer>(Arrays.asList(new Integer[] {17, 18, 19, 20}));
        ArrayList<Integer> innerList32 = new ArrayList<Integer>(Arrays.asList(new Integer[] {21, 22, 23, 24}));
        
        listOLists.addCustomList(innerList11, innerList12, innerList21, innerList22, innerList31, innerList32);
    }
    @Test(expected = AssertionError.class)
    public void givenNestedList_whenElementToBeFoundAt_H_thenAssertionErrorExpectedAsListOccursAtHead() {
        assertEquals(null, listOLists.getValue("H"));
    }

    @Test(expected = AssertionError.class)
    public void givenNestedList_whenElementToBeFoundAt_T_thenAssertionErrorExpectedAsListOccursAtTail() {
        assertEquals(null, listOLists.getValue("T"));
    }

    @Test(expected = AssertionError.class)
    public void  givenNestedList_whenElementToBeFoundAt_HHT_with_T_AtTheEnd_thenAssertionErrorExpected() {
        assertEquals(null, listOLists.getValue("HHT"));
    }

    @Test
    public void  givenNestedList_whenElementToBeFoundAt_HHH_thenReturnsValidOutput() {
        assertEquals(1, Integer.parseInt(listOLists.getValue("HHH")));
    }

    @Test
    public void givenNestedList_whenElementToBeFoundAt_HHTH_thenReturnsValidOutput() {
        assertEquals(2, Integer.parseInt(listOLists.getValue("HHTH")));
    }

    @Test
    public void givenNestedList_whenElementToBeFoundAt_HHTTH_thenReturnsValidOutput() {
        assertEquals(3, Integer.parseInt(listOLists.getValue("HHTTH")));
    }

    @Test
    public void givenNestedList_whenElementToBeFoundAt_HHTTTH_thenReturnsValidOutput() {
        assertEquals(4, Integer.parseInt(listOLists.getValue("HHTTTH")));
    }

    @Test
    public void givenNestedList_whenElementToBeFoundAt_HTHH_thenReturnsValidOutput() {
        assertEquals(5, Integer.parseInt(listOLists.getValue("HTHH")));
    }
}