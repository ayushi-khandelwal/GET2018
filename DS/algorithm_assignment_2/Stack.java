package algorithm_assignment_2;

public class Stack {
	int max;
	char[] array;
	int top;
	
	public Stack(int max) {
		this.max = max;
		 array = new char[max];
		 top = -1;
	}
	
	public boolean push(char value) {
		top++;
		if(top == max)
			return false;
		
		array[top] = value;
		return true;
	}

	public char pop() {
		if(isEmpty())
			return 0;
		
		return array[top--];
	}

	public char peek() {
		if(top == -1 || top == max)
			throw new AssertionError();
		
		return (array[top]);
	}

	public boolean isEmpty() {
		if(top == -1)
			return true;
		
		return false;
	}

	public char[] displayStack() {
	    System.out.println("Top is " + top);
		if(top == -1 || top == max)
			throw new AssertionError();
		
		return array;
	}

	public int countElements() {
		return (top + 1);
	}

    public boolean contains(char node) {
        for(char iterator : array) {
            if(iterator == node)
                return true;
        }
        return false;
    }

    public void clear() {
        if(!isEmpty())
            pop();
    }
}
