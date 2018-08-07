package ds_Assignment_3.cricket;

import ds_Assignment_3.priority_queue.PriorityQueue;

/**
 * @author Ayushi Khandelwal
 *
 */
public class Cricket { 
    
    PriorityQueue priorityQueue = new PriorityQueue();
    int currentBowler = 0;
    int noOfBowlers;
    int noOfBalls;
    String orderOfBowlers[];
    
    /**
     * @param noOfBowlers
     * @param noOfBalls
     * 
     * parameterized constructor whose arguments are number of bowlers and total number of balls
     */
    public Cricket(int noOfBowlers, int noOfBalls) {
        this.noOfBalls = noOfBalls;
        this.noOfBowlers = noOfBowlers;
        orderOfBowlers = new String[noOfBalls];
        }
    
    /**
     * @param string
     * @param ball
     * 
     * bowler name and total number of balls bowl by that bowler are taken as an arguments
     * and this method adds bowler with balls in priority queue
     */
    public void addBowler(String string, int ball) {
        
        //if bowler name is null or number of balls are negative then throw AssertionError
        if(!((string == "" || ball < 0) && (currentBowler < noOfBowlers))) {
            priorityQueue.enqueue(string, ball);
            currentBowler++;
        }
        else
            throw new AssertionError();
    }

    /**
     * @return order of bowlers chosen by captain for Virat to score as low as possible
     */
    public String[] calculateOrderOfBowlers() {
        System.out.print("Order of bowlers is : ");
        for(int i = 0; i < noOfBalls; i++) {
            orderOfBowlers[i] = priorityQueue.getItem();
            System.out.print(orderOfBowlers[i] + ", ");
        }
        System.out.println("");
        return orderOfBowlers;
    }
}
