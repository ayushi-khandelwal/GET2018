package algorithm_assignment_2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    Graph graph = new Graph();
    
    @Test
    public void test() {
        graph.addEdge(new Edge(10, 'a', 'b'));
        graph.addEdge(new Edge(20, 'b', 'c'));
        graph.addEdge(new Edge(20, 'b', 'd'));
        graph.addEdge(new Edge(30, 'c', 'd'));
        graph.addEdge(new Edge(40, 'd', 'a'));
        assertEquals(true, graph.isConnected());
    }

}
