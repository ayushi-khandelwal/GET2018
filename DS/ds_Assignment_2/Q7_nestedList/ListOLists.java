package ds_Assignment_2.Q7_nestedList;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Ayushi Khandelwal
 *
 */
public class ListOLists implements IList {
    public List<Object> listOfList;
    List<Object> listOuter1;
    List<Object> listOuter2;
    List<Object> listOuter3;

    /**
     * default non-parameterized constructor used to add values in various
     * innerlists and add them in outerlist
     */
    public ListOLists() {
        listOfList = new ArrayList<>();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        listOuter1 = new ArrayList<>();
        listOuter2 = new ArrayList<>();
        listOuter3 = new ArrayList<>();
        listOfList.add(listOuter1);
        listOfList.add(listOuter2);
        listOfList.add(listOuter3);
    }
    
    public void addCustomList(List<Integer> listInner11, List<Integer> listInner12, List<Integer> listInner21, List<Integer> listInner22, List<Integer> listInner31, List<Integer> listInner32) {
        listOuter1.add(listInner11);
        listOuter1.add(listInner12);
        listOuter2.add(listInner21);
        listOuter2.add(listInner22);
        listOuter3.add(listInner31);
        listOuter3.add(listInner32);
    }

    @Override
    public String getValue(List<Object> list, String string) {
        return (getElement(listOfList, string));
    }

    /**
     * @param list
     * @param string
     * @return element from nested list accessed by using parameter string
     */
    @SuppressWarnings("unchecked")
    public String getElement(List<Object> list, String string) {
        int value = -1;
        
        if (string.charAt(0) == 'T' && string.length() == 1) 
            throw new AssertionError();
        
        else if (string.charAt(0) == 'H' && string.length() == 1) {
            if ((list.get(0)) instanceof Integer) {
                value = ((Integer) list.get(0));
                return (value + "");
            }   
            throw new AssertionError("List instance found at head");
        }
        
        else if (string.charAt(0) == 'T') {
            list.remove(0);
            return getElement((List<Object>) list, string.substring(1, string.length()));
        }
        
        else if (string.charAt(0) == 'H') 
            return getElement((List<Object>) list.get(0), string.substring(1, string.length()));
       
        return null;
    }
}