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
    public void test_LargestValue_SingleH_ReturnInvalidOutput() { 
        assertEquals(null, listOLists.getValue("H"));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_SingleT_ReturnInvalidOutput() { 
        assertEquals(null, listOLists.getValue("T"));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_EndsWithT_ReturnInvalidOutput() { 
        assertEquals(null, listOLists.getValue("HHT"));
    }

    @Test
    public void test_LargestValue__ReturnValidOutput() { 
        assertEquals(1, Integer.parseInt(listOLists.getValue("HHH")));
    }

    @Test
    public void test_LargestValue_HHTH_ReturnValidOutput() { 
        assertEquals(2, Integer.parseInt(listOLists.getValue("HHTH")));
    }

    @Test
    public void test_LargestValue_HHTTH_ReturnValidOutput() { 
        assertEquals(3, Integer.parseInt(listOLists.getValue("HHTTH")));
    }

    @Test
    public void test_LargestValue_HHTTTH_ReturnValidOutput() { 
        assertEquals(4, Integer.parseInt(listOLists.getValue("HHTTTH")));
    }

    @Test
    public void test_LargestValue_HHTH_ReturnInvalidOutput() { 
        assertEquals(5, Integer.parseInt(listOLists.getValue("HTHH")));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_IfInputIsAccessingArrayList_ReturnInvalidOutput() { 
        assertEquals(null, listOLists.getValue("HTH"));
    }
}