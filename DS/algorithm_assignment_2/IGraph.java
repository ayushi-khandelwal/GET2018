package algorithm_assignment_2;

import java.util.List;
import java.util.Set;

public interface IGraph {
    public boolean isConnected(List<Edge> edgeList);
    public Set<Character> reachable(char reachableNode, List<Edge> edgeList);
    public List<Edge> minimumSpanningTree(List<Edge> edgeList);
}
