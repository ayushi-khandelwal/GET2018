package algorithm_assignment_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class GraphTest {

    Graph graph = new Graph();
    
    @Test
    public void test_IsCOnnected_WhenGraphIsConnected_ReturnTrue() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(20, 'b', 'c'));
        list.add(new Edge(20, 'b', 'd'));
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(30, 'c', 'd'));
        list.add(new Edge(40, 'd', 'a'));
        assertEquals(true, graph.isConnected(list));
    }
    
    @Test
    public void test_IsCOnnected_WhenGraphIsConnectedAndGraphContainsAsMinimumEdgesAsPossible_ReturnTrue() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(30, 'a', 'c'));
        list.add(new Edge(30, 'c', 'd'));
        assertEquals(true, graph.isConnected(list));
    }
    
    @Test
    public void test_IsCOnnected_WhenGraphIsNotConnected_ReturnFalse() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(30, 'c', 'd'));
        assertEquals(false, graph.isConnected(list));
    }
    
    @Test
    public void test_IsCOnnected_WhenGraphIsConnectedAndMultipleCyclesArePresent_ReturnTrue() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 's', 'a'));
        list.add(new Edge(30, 'a', 'd'));
        list.add(new Edge(10, 'd', 'g'));
        list.add(new Edge(30, 'g', 'e'));
        list.add(new Edge(10, 'e', 'b'));
        list.add(new Edge(30, 'g', 'f'));
        list.add(new Edge(10, 'f', 'c'));
        assertEquals(true, graph.isConnected(list));
    }

    @Test(expected = AssertionError.class)
    public void test_IsCOnnected_WhenEdgeIsNotPassed_ThrowAssertionError() {
        List<Edge> list = new ArrayList<Edge>();
        assertEquals(AssertionError.class, graph.isConnected(list));
    }
    
    @Test
    public void test_Reachable_WhenNodeIsPassed_ReturnReachableNodesToThatNode() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(20, 'c', 'b'));
        list.add(new Edge(30, 'c', 'd'));
        list.add(new Edge(40, 'a', 'd'));
        
        Set<Character> expectedSet = new HashSet<>();
        expectedSet.add('a');
        expectedSet.add('b');
        expectedSet.add('c');
        expectedSet.add('d');
        assertEquals(expectedSet , graph.reachable('a', list));
    }

    @Test(expected = AssertionError.class)
    public void test_Reachable_WhenEdgeIsNotPassed_ThrowAssertionError() {
        List<Edge> list = new ArrayList<Edge>();
        assertEquals(AssertionError.class, graph.reachable('a', list));
    }
    
    @Test
    public void test_MinimumSpanningTree_WhenListOfEdgesIsPassed_ReturnListOfEdgesWhichIsInMST() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(20, 'b', 'c'));
        list.add(new Edge(20, 'b', 'd'));
        list.add(new Edge(30, 'c', 'd'));
        list.add(new Edge(40, 'd', 'a'));
        List<Edge> expectedList = new ArrayList<Edge>();
        expectedList.addAll(graph.minimumSpanningTree(list));      

        List<Edge> actualList = new ArrayList<Edge>();
        actualList.add(new Edge(10, 'a', 'b')); 
        actualList.add(new Edge(20, 'b', 'c')); 
        actualList.add(new Edge(20, 'b', 'd'));  
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
        
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
  
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
    }
    
    @Test
    public void test_MinimumSpanningTree_WhenListOfEdgesIsPassedAndGraphIsNotConnected_ReturnListOfEdgesWhichIsInMST() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(30, 'a', 'c'));
        list.add(new Edge(30, 'c', 'd'));
        
        List<Edge> expectedList = new ArrayList<Edge>();
        expectedList.addAll(graph.minimumSpanningTree(list));      

        List<Edge> actualList = new ArrayList<Edge>();
        actualList.add(new Edge(10, 'a', 'b')); 
        actualList.add(new Edge(30, 'a', 'c'));
        actualList.add(new Edge(30, 'c', 'd'));   
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
        
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
  
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
    }

    @Test
    public void test_WhenListOfEdgesIsPassedAndGraphIsNotConnected_ReturnListOfEdgesWhichIsInMST() {
        List<Edge> list = new ArrayList<Edge>();
        list.add(new Edge(10, 'a', 'b'));
        list.add(new Edge(30, 'c', 'd'));
        list.add(new Edge(30, 'a', 'c'));
        
        List<Edge> expectedList = new ArrayList<Edge>();
        expectedList.addAll(graph.minimumSpanningTree(list));      

        List<Edge> actualList = new ArrayList<Edge>();
        actualList.add(new Edge(10, 'a', 'b')); 
        actualList.add(new Edge(30, 'c', 'd')); 
        actualList.add(new Edge(30, 'a', 'c'));  
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
        
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
  
        assertEquals(actualList.get(0).getWeight(), expectedList.get(0).getWeight());
        assertEquals(actualList.get(1).getNode1(), expectedList.get(1).getNode1());
        assertEquals(actualList.get(2).getNode2(), expectedList.get(2).getNode2());
    }
}
