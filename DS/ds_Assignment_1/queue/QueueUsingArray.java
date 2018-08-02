package ds_Assignment_1.queue;

public class QueueUsingArray implements Queue {
	int max;
	int[] array;
	int start, end;
	
	public QueueUsingArray(int max) {
		this.max = max;
		 array = new int[max];
		 start = 0;
		 end = -1;
	}

	@Override
	public boolean add(int value) {
		if(start == -1)
			start++;
		
		end++;
		
		if(end == max){
			return false;
		}
		
		array[end] = value;
		return true;
	}

	@Override
	public boolean delete() {
		if(isEmpty()){
			return false;
		}
		if(start == end){
			start = -1;
			end = -1;
		}
		
		start--;
		return true;
	}

	@Override
	public boolean isEmpty() {
		if(end == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(start == max-1)
			return true;
		return false;
	}
	
}
