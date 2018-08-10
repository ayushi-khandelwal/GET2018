package algorithm_assignment_2;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

    List<Edge> list = new ArrayList<>();
    
    public void addEdge(Edge edge) {
        list.add(edge);
    }
    
    public int noOfEdges() {
        return list.size();
    }
    
    @Override
    public boolean isConnected() {
        int nodesVisited = 0;
        while(nodesVisited != noOfEdges()) {
            
        }
        return false;
    }

    @Override
    public List<Edge> reachable(Edge reachableNode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Edge> shortestPath(Edge node1, Edge node2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Edge> minimumSpanningTree() {
        // TODO Auto-generated method stub
        return null;
    }

}
