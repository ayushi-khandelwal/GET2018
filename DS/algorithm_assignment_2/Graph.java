package algorithm_assignment_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements IGraph {

    Stack stack;
    Set<Character> noOfNodes;
    List<Edge> mstEdges;
   
    private int noOfEdges(List<Edge> list) {
        return list.size();
    }

    private int noOfNodes(List<Edge> list) {
        noOfNodes = new HashSet<>();
        for(Edge e : list) {
            noOfNodes.add(e.getNode1());
            noOfNodes.add(e.getNode2());
        }
        return noOfNodes.size();
    }

    @Override
    public boolean isConnected(List<Edge> edgeList) {
        if(edgeList.size() == 0)
            throw new AssertionError();
        
        stack = new Stack(noOfNodes(edgeList));
        Set<Character> nodesVisited = new HashSet<>();
        int egdeListIterator = 0;
        int loopIterator = 0;
        while(nodesVisited.size() != noOfNodes(edgeList)) {
            if(loopIterator == 2)
                return false;
            
            for(Edge edge : edgeList) {
                if(nodesVisited.size() == 0) {
                    nodesVisited.add(edgeList.get(egdeListIterator).getNode1());
                    nodesVisited.add(edgeList.get(egdeListIterator).getNode2());
                    stack.push(edgeList.get(egdeListIterator).getNode1());
                    stack.push(edgeList.get(egdeListIterator).getNode2());
                }
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

    @Override
    public Set<Character> reachable(char reachableNode, List<Edge> edgeList) {
        Set<Character> rechableNodeSet = new HashSet<>();
        rechableNodeSet.add(reachableNode);
            for(Edge edgeListIterator : edgeList) {
                if(rechableNodeSet.contains(edgeListIterator.getNode1())) 
                    rechableNodeSet.add(edgeListIterator.getNode2());
                    
                else if(rechableNodeSet.contains(edgeListIterator.getNode2()))
                    rechableNodeSet.add(edgeListIterator.getNode1());

            }
        return rechableNodeSet;
    }

    @Override
    public List<Edge> minimumSpanningTree(List<Edge> edgeList) {
        mstEdges = new ArrayList<>();
        
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
            if(noOfEdges(mstEdges) != (noOfNodes(edgeList) - 1)) {
                if(!checkCycle(edgeIterator, edgeList)) {
                    if(!mstEdges.contains(edgeIterator))
                        mstEdges.add(edgeIterator);
                }
            }
            else
                break;
        }
        return mstEdges;
    }

    private boolean checkCycle(Edge edgeIterator, List<Edge> edgeList) {
        if(mstEdges.contains(edgeIterator.getNode1())) {
            if(!mstEdges.contains(edgeIterator.getNode2())) 
                return false;
        } 
        
        else if(!mstEdges.contains(edgeIterator.getNode1())) {
            if(mstEdges.contains(edgeIterator.getNode2())) 
                return false;
        }
        
        else if(!mstEdges.contains(edgeIterator.getNode1())) {
            if(!mstEdges.contains(edgeIterator.getNode2())) 
                return false;
        }
        
        else if(mstEdges.contains(edgeIterator.getNode1())) {
            if(mstEdges.contains(edgeIterator.getNode2()) && !isConnected(edgeList)) 
                return true;
        }
        return false;
    }

}
