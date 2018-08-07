package ds_Assignment_3.cricket;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class CricketTest {

    //this object passes number of bowlers and total number of balls
    Cricket cricket = new Cricket(3, 10);
    
    @Test
    public void test_WhenThreeBowlersAreAdded_ReturnValidOutput() {
        cricket.addBowler("Bowler1", 5);
        cricket.addBowler("Bowler2", 3);
        cricket.addBowler("Bowler3", 2);
        
        String expectedArray[] = {"Bowler1", "Bowler1", "Bowler1", "Bowler2", "Bowler3" ,
                                  "Bowler1", "Bowler2" ,"Bowler3" ,"Bowler1" ,"Bowler2"};
        
        assertArrayEquals(expectedArray, cricket.calculateOrderOfBowlers());
    }

    @Test
    public void test_WhenTwoBowlersBowlEqualNumberOfBalls_ReturnValidOutput() {
        cricket.addBowler("Bowler1", 3);
        cricket.addBowler("Bowler2", 3);
        cricket.addBowler("Bowler3", 4);
        
        String expectedArray[] = {"Bowler3", "Bowler3", "Bowler1", "Bowler2", "Bowler3" ,
                                  "Bowler1", "Bowler2" ,"Bowler3" ,"Bowler1" ,"Bowler2"};
        
        assertArrayEquals(expectedArray, cricket.calculateOrderOfBowlers());
    }

    @Test(expected = AssertionError.class)
    public void test_WhenBowlerNameIsNull_ThrowAssertionError() {
        cricket.addBowler("", 3);
        cricket.addBowler("Bowler2", 3);
    }

    @Test
    public void test_WhenOneOfBowlerBowlZeroBalls_ReturnValidOutput() {
        cricket.addBowler("Bowler1", 0);
        cricket.addBowler("Bowler2", 3);
        cricket.addBowler("Bowler3", 7);
        
        String expectedArray[] = {"Bowler3", "Bowler3", "Bowler3", "Bowler3", "Bowler3" ,
                                  "Bowler2", "Bowler3" ,"Bowler2" ,"Bowler3" ,"Bowler2"};
        
        assertArrayEquals(expectedArray, cricket.calculateOrderOfBowlers());
    }

    @Test(expected = AssertionError.class)
    public void test_WhenBowlerHavingNegativeNumberOfBalls_ThrowAssertionError() {
        cricket.addBowler("Bowler1", 10);
        cricket.addBowler("Bowler2", -1);
    }
}
