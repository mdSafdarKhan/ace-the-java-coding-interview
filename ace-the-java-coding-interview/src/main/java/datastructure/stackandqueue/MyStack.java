package datastructure.stackandqueue;

public class MyStack {

	int maxSize;
	int top;
	int[] array;
	
	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
		this.top = -1;
	}
	
	public int getCapacity() {
		return maxSize;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	public int top() {
		if(isEmpty()) {
			System.err.println("Stack is empty!");
			return -1;
		}
		return array[top];
	}
	
	public void push(int value) {
		if(isFull()) {
			System.err.println("Stack is full!");
			return;
		}
		array[++top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empy!");
			return -1; 
		}
		int value = array[top--];
		return value;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack(5);
		System.out.println(stack.getCapacity());
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		stack.push(10);
		stack.push(20);
		System.out.println(stack.top());
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.top());
		System.out.println(stack.isFull());
		stack.push(90);
		
	}
}
