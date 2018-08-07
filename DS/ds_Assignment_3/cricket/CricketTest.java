package ds_Assignment_3.cricket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CricketTest {

    Cricket cricket = new Cricket(3, 20);
    
    @Before
    public void init() {
        cricket.addBowler("Bowler1", 10);
        cricket.addBowler("Bowler2", 6);
        cricket.addBowler("Bowler3", 4);
    }
    
    @Test
    public void test() {
        String expectedArray[] = {"Bowler1", "Bowler1", "Bowler1", "Bowler1", "Bowler1" ,
                "Bowler2" ,"Bowler1" ,"Bowler2" ,"Bowler3" ,"Bowler1" ,
                "Bowler2" ,"Bowler3" ,"Bowler1" ,"Bowler2" ,"Bowler3" ,
                "Bowler1" ,"Bowler2" ,"Bowler3" ,"Bowler1" ,"Bowler2"};
        
        assertArrayEquals(expectedArray, cricket.calculateOrderOfBowlers());
    }

}
