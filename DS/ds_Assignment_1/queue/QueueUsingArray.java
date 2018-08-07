package ds_Assignment_1.queue;

public class QueueUsingArray implements Queue {
	int max;
	int[] array;
	int front, rear;
	int size;
	
	public QueueUsingArray(int max) {
		this.max = max;
		 array = new int[max];
		 front = 0;
		 rear = -1;
		 size = 0;
	}

	@Override
	public boolean enqueue(int value) {
		if(isFull()){
			return false;
		}
		
		rear = (rear + 1) % max;
		array[rear] = value;
		size++;
		return true;
	}

	@Override
	public int dequeue() {
		if(isEmpty()){
			return -1;
		}
		
		int item = array[front];
		front = (front + 1) % max;
		size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public int peek() {
		if (isEmpty()) {
            return -1;
        } else {
            return array[front];
        }
    }
	
	public boolean isFull() {
		if(size == max)
			return true;
		return false;
	}
}
