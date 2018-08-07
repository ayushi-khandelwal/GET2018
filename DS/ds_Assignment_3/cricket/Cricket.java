package ds_Assignment_3.cricket;

import ds_Assignment_3.priority_queue.PriorityQueue;
import java.util.HashMap;

public class Cricket {

    private HashMap< String, Integer> map;

    PriorityQueue priorityQueue = new PriorityQueue();
    int currentBowler = 0;
    int noOfBowlers;
    int noOfBalls;
    String orderOfBowlers[];
    
    public Cricket(int noOfBowlers, int noOfBalls) {
        this.noOfBalls = noOfBalls;
        this.noOfBowlers = noOfBowlers;
        map = new HashMap<>();
        orderOfBowlers = new String[noOfBalls];
        }
    
    public void addBowler(String string, int ball) {
        if(currentBowler < noOfBowlers) {
            priorityQueue.enqueue(string, ball);
            currentBowler++;
        }
        
        else
            throw new AssertionError();
    }

    public String[] calculateOrderOfBowlers() {
        for(int i = 0; i < noOfBalls; i++) {
            orderOfBowlers[i] = priorityQueue.getItem();
            System.out.print(orderOfBowlers[i]);
        }
        return orderOfBowlers;
    }
}
