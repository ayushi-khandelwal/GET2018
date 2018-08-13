package algorithm_assignment_2;

public class Edge {
    int weight;
    char node1;
    char node2;
    
    public Edge(int weight, char node1, char node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }

    public char getNode1() {
        return node1;
    }

    public char getNode2() {
        return node2;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setNode1(char node1) {
        this.node1 = node1;
    }

    public void setNode2(char node2) {
        this.node2 = node2;
    }

}
