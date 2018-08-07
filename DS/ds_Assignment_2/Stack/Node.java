package ds_Assignment_2.Stack;

public class Node {
    String element;
    Node linkNode;
    
    public Node(String element) {
        super();
        this.element = element;
    }

    public String getElement() {
        return element;
    }
    
    public Node getLinkNode() {
        return linkNode;
    }

    public void setLinkNode(Node linkNode) {
        this.linkNode = linkNode;
    }
}
