package algorithm_assignment_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ayushi
 *
 */
public class Graph implements IGraph {

    Stack stack;
    Set<Character> noOfNodes;
    List<Edge> mstEdgeList;
   
    /**
     * @param list
     * @return no of edges given list contains
     */
    private int noOfEdges(List<Edge> edgeList) {
        return edgeList.size();
    }

    /**
     * @param list
     * @return no of vertices/nodes that given list contains
     */
    private int noOfNodes(List<Edge> edgeList) {
        noOfNodes = new HashSet<>();
        for(Edge edge : edgeList) {
            noOfNodes.add(edge.getNode1());
            noOfNodes.add(edge.getNode2());
        }
        return noOfNodes.size();
    }

    /**
     * @param list of edges
     * @return true if graph is connected, else return false
     */
    @Override
    public boolean isConnected(List<Edge> edgeList) {
        if(edgeList.size() == 0)
            throw new AssertionError();
        
        //stack is used to traverse back the visited nodes
        stack = new Stack(noOfNodes(edgeList));
        Set<Character> nodesVisited = new HashSet<>();
        int egdeListIterator = 0;
        int loopIterator = 0;
        while(nodesVisited.size() != noOfNodes(edgeList)) {
            if(loopIterator == 2)
                return false;
            
            for(Edge edge : edgeList) {
                
                //when no vertex/edge is visited yet
                if(nodesVisited.size() == 0) {
                    nodesVisited.add(edgeList.get(egdeListIterator).getNode1());
                    nodesVisited.add(edgeList.get(egdeListIterator).getNode2());
                    stack.push(edgeList.get(egdeListIterator).getNode1());
                    stack.push(edgeList.get(egdeListIterator).getNode2());
                }
                
                //when some vertex/nodes are visited
                else if((edgeList.get(egdeListIterator).getNode1() == edge.getNode1() && edgeList.get(egdeListIterator).getNode2() != edge.getNode2()) ||
                        (edgeList.get(egdeListIterator).getNode2() == edge.getNode1() && edgeList.get(egdeListIterator).getNode1() != edge.getNode2()) ||
                        (edgeList.get(egdeListIterator).getNode1() == edge.getNode2() && edgeList.get(egdeListIterator).getNode2() != edge.getNode1()) ||
                        (edgeList.get(egdeListIterator).getNode2() == edge.getNode2() && edgeList.get(egdeListIterator).getNode1() != edge.getNode1())) {
                    
                    nodesVisited.add(edge.getNode1());
                    nodesVisited.add(edge.getNode2());
                    
                    if(stack.contains(edge.getNode1())) 
                        stack.pop();
                    
                    else 
                        stack.push(edge.getNode1());
                    
                    if(stack.contains(edge.getNode2()))
                        stack.pop();
                    
                    else
                        stack.push(edge.getNode2());
                    
                    egdeListIterator++;
                }
            }
            loopIterator++;
        }
        return true;
    }

    /**
     * @param node from where we need to find reachable nodes and list of edges
     * @return set of nodes which are reachable from given node
     */
    @Override
    public Set<Character> reachable(char reachableNode, List<Edge> edgeList) {
        if(edgeList.size() == 0)
            throw new AssertionError();
        
        Set<Character> rechableNodeSet = new HashSet<>();
        
        //given node is added in the set of reachable node
        rechableNodeSet.add(reachableNode);
        
        for(Edge edgeListIterator : edgeList) {
            if(rechableNodeSet.contains(edgeListIterator.getNode1())) 
               rechableNodeSet.add(edgeListIterator.getNode2());
                
            else if(rechableNodeSet.contains(edgeListIterator.getNode2()))
               rechableNodeSet.add(edgeListIterator.getNode1());
        }
        return rechableNodeSet;
    }

    /**
     * @param list of edges
     * @return list of edges which minimum spanning tree contains
     */
    @Override
    public List<Edge> minimumSpanningTree(List<Edge> edgeList) {
        if(edgeList.size() == 0)
            throw new AssertionError();
        
        mstEdgeList = new ArrayList<>();
          
        //sort all edges in non-decreasing order
        for(Edge edgeIterator1 : edgeList) {
            for(Edge edgeIterator2 : edgeList) {
                if(edgeIterator2.getWeight() > edgeIterator1.getWeight()) {
                    int temp = edgeIterator1.getWeight();
                    edgeIterator1.setWeight(edgeIterator2.getWeight());
                    edgeIterator2.setWeight(temp);
                }
            }
        }
        
      //pick smallest edge. Add it if cycle is not formed, else discard it.
        for(Edge edgeIterator : edgeList) { 
            if(noOfEdges(mstEdgeList) != (noOfNodes(edgeList) - 1)) {
                if(!checkCycle(edgeIterator, edgeList)) {
                    if(!mstEdgeList.contains(edgeIterator))
                        mstEdgeList.add(edgeIterator);
                }
            }
            else
                break;
        }
        return mstEdgeList;
    }

    /**
     * @param edge and list of edges
     * @return true if cycle is formed in graph, else return false
     */
    private boolean checkCycle(Edge edgeIterator, List<Edge> edgeList) {
        if((mstEdgeList.contains(edgeIterator.getNode1()) || mstEdgeList.contains(edgeIterator.getNode2())) && !isConnected(edgeList)) 
                return true;
        
        return false;
    }
}