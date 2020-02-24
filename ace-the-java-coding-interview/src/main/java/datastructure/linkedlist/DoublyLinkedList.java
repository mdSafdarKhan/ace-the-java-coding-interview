package datastructure.linkedlist;

public class DoublyLinkedList {

	int size;
	Node headNode;
	
	class Node{
		String data;
		Node previousNode;
		Node nextNode;
	}
	
	public DoublyLinkedList() {
		headNode = null;
		size = 0;
	}
	
	public void insertAtHead(String data) {
		Node node = new Node();
		node.data = data;
		headNode = node;
		size++;
	}
	
	public void insertAtEnd(String data) {
		
		Node node = new Node();
		node.data = data;
		
		Node currentNode = headNode;
		while(currentNode != null) {
			if(currentNode.nextNode == null) {
				break;
			}
			currentNode = currentNode.nextNode;
		}
		currentNode.nextNode = node;
		node.previousNode = currentNode;
		size++;
	}
	
	public void insertAfter(String data, String previous) {
		Node temp = headNode;
		while(temp != null) {
			String nodeData = temp.data;
			if(nodeData.equals(previous)) {
				Node newNode = new Node();
				newNode.data = data;
				newNode.nextNode = temp.nextNode;
				newNode.previousNode = temp;
				temp.nextNode = newNode;
			}
			temp = temp.nextNode;
		}
		size++;
	}
	
	public void searchNode(String data) {
		boolean found = false;
		Node temp = headNode;
		while(temp != null) {
			if(temp.data.equals(data)) {
				found = true;
			}
			temp = temp.nextNode;
		}
		System.out.println(data + " found: " + found);
	}
	
	public void deleteAtHead() {
		Node temp = headNode.nextNode;
		if(temp == null) {
			headNode = null;
			return;
		}
		headNode = temp;
		size--;
	}
	
	public void deleteByValue(String data) {
		
		if(isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}
		
		Node currentNode = headNode;
		
		if(currentNode.data.equals(data)) {
			deleteAtHead();
			return;
		}
		
		while(currentNode != null) {
			if(currentNode.data.equals(data)) {
				currentNode.previousNode.nextNode=currentNode.nextNode;
				if(currentNode.nextNode!=null) {
					currentNode.nextNode.previousNode=currentNode.previousNode;
				}
				size--;
			}
			currentNode = currentNode.nextNode;
		}
		
	}
	
	public void printList() {
		Node temp = headNode;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.nextNode;
		}
		System.out.println(temp);
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public void length() {
		int size = 0;
		Node temp = headNode;
		while(temp != null) {
			size++;
			temp = temp.nextNode;
		}
		System.out.println("Length: " + size);
	}
	
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insertAtHead("A");
		doublyLinkedList.printList();
		doublyLinkedList.insertAtEnd("B");
		doublyLinkedList.insertAtEnd("C");
		doublyLinkedList.printList();
		doublyLinkedList.insertAfter("OMEGA", "A");
		doublyLinkedList.printList();
		doublyLinkedList.searchNode("B");
		doublyLinkedList.searchNode("THETA");
		doublyLinkedList.deleteAtHead();
		doublyLinkedList.printList();
		doublyLinkedList.deleteByValue("B");
		doublyLinkedList.printList();
		doublyLinkedList.length();
	}
}
