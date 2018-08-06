package ds_Assignment_2.Q5_nestedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayushi Khandelwal
 *
 */
public class ListOLists implements IList {
    List<List<Integer>> listOfList;

    /**
     * default non-parameterized constructor used to add values in various
     * innerlists and add them in outerlist
     */
    public ListOLists() {
        listOfList = new ArrayList<>();
    }
    
    public void addCustomList(List<Integer> list) {
        listOfList.add(list);
    }

    @Override
    public int sum() {
        int sum = 0;
        for (List<Integer> list : listOfList) {
            for (Integer i : list) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public int largestValue() {
        int largest = 0;
        for(List<Integer> list : listOfList) {
            for (Integer i : list) {
                if(largest < i) {
                    largest = i;
                }
            }
        }
        return largest;
    }

    @Override
    public boolean search(int value) {
        for(List<Integer> list : listOfList) {
            for (Integer i : list) {
            if(i == value)
                return true;
            }
        }
        return false;
    }
}
