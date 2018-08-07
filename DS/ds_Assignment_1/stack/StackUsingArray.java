package ds_Assignment_1.stack;

public class StackUsingArray implements Stack{
	int max;
	int[] array;
	int top;
	
	public StackUsingArray(int max) {
		this.max = max;
		 array = new int[max];
		 top = -1;
	}
	
	
	@Override
	public boolean push(int value) {
		top++;
		if(top >= max){
			return false;
		}
		
		array[top] = value;
		return true;
	}

	@Override
	public boolean pop() {
		if(isEmpty()){
			return false;
		}
		
		top--;
		return true;
	}

	@Override
	public int peek() {
		if(top <= -1 || top >= max){
			throw new AssertionError();
		}
		return (array[top]);
	}

	@Override
	public int[] displayStack() {
		if(top == -1 || top == max){
			return null;
		}
		return array;
	}

	@Override
	public boolean isEmpty() {
		if(top <= -1)
			return true;
		return false;
	}

}
