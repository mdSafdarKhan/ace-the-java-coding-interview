package datastructure.stackandqueue;

public class MyQueue {

	int capacity;
	int[] array;
	int front;
	int rear;
	int currentSize;
	
	public MyQueue(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.currentSize = 0;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public boolean isFull() {
		return currentSize == capacity;
	}
	
	public int getFront() {
		return array[front];
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			System.err.println("Queue is full!");
			return;
		}
		rear = (rear + 1) % capacity;
		array[rear] = data;
		currentSize++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return -1;
		}
		int temp = array[front];
		front = (front + 1) % capacity;
		currentSize--;
		return temp;
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(4);
		System.out.println("Capacity: " + queue.getCapacity());
		System.out.println("Empty: " + queue.isEmpty());
		System.out.println("Full: " + queue.isFull());
		System.out.println("Front: " + queue.getFront());
		queue.enqueue(100);
		System.out.println();
		System.out.println("Capacity: " + queue.getCapacity());
		System.out.println("Empty: " + queue.isEmpty());
		System.out.println("Full: " + queue.isFull());
		System.out.println("Front: " + queue.getFront());
		queue.dequeue();
		System.out.println();
		System.out.println("Capacity: " + queue.getCapacity());
		System.out.println("Empty: " + queue.isEmpty());
		System.out.println("Full: " + queue.isFull());
		System.out.println("Front: " + queue.getFront());
	}
}
