package algorithm_assignment_2;

import java.util.List;

public interface IGraph {
    public boolean isConnected();
    public List<Edge> reachable(Edge reachableNode);
    public List<Edge> minimumSpanningTree();
    public List<Edge> shortestPath(Edge node1, Edge node2);
}
