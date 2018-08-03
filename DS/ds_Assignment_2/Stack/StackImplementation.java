package ds_Assignment_2.Stack;

public class StackImplementation {
    Node top;
    private int noOfItemsInStack;

    public String pop() {
        if (top == null) 
            return null;
        else {
            String poppedData = top.getElement();
            top = top.getLinkNode();
            noOfItemsInStack--;
            return poppedData;
        }
    }

    public int getNoOfItemInStack() {
        return noOfItemsInStack;
    }

    public boolean push(String element) {
        Node node = new Node(element);
        if (top == null) {
            top = node;
        } else {
            node.setLinkNode(top);
            top = node;
        }
        noOfItemsInStack++;
        return true;
    }

    public String peek() {
        if (top == null)
            return null;
        else 
            return top.getElement();
       
    }

	public boolean isEmpty() {
		return(top == null);
	}
}
