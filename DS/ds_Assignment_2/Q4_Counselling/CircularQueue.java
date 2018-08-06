package ds_Assignment_2.Q4_Counselling;

/**
 * @author Ayushi Khandelwal
 *
 */
public class CircularQueue implements Queue {
    int front;
    int rear;
    Student[] queueArray;
    int MAX_SIZE;

    /**
     * @param max
     * parameterized constructor used to set values
     */
    public CircularQueue(int max) {
        front = -1;
        rear = -1;
        MAX_SIZE = max;
        queueArray = new Student[MAX_SIZE];
    }

    @Override
    public Student deQueue() {
        if (front == -1) {
            return null;
        } else {
            Student deletedElement = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == MAX_SIZE - 1) {
                front = 0;
            } else {
                front++;
            }
            return deletedElement;
        }
    }

    @Override
    public boolean enQueue(Student newStudent) {
        if (front == rear + 1 || (rear == MAX_SIZE - 1 && front == 0)) {
            return false;
        } else {
            if (front == -1) {
                front++;
                rear++;
            } else if (rear == MAX_SIZE - 1) {
                rear = 0;
            } else {
                rear++;
            }
            queueArray[rear] = newStudent;
            return true;
        }
    }

    @Override
    public Student peek() {
        if (front == -1) {
            return null;
        } else {
            return queueArray[front];
        }
    }
}
