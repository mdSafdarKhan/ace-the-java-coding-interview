package datastructure.linkedlist;

import datastructure.linkedlist.DoublyLinkedList.Node;

public class SinglyLinkedList {

	int size;
	Node headNode;
	
	class Node{
		String data;
		Node nextNode;
	}
	
	public SinglyLinkedList() {
		headNode = null;
		size = 0;
	}
	
	public void insertAtHead(String data) {
		Node node = new Node();
		node.data = data;
		node.nextNode = headNode;
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
		
		if(headNode.data.equals(data)) {
			deleteAtHead();
			size--;
			return;
		}
		
		Node currentNode = headNode;
		Node previousNode = null;
		while(currentNode != null) {
			if(currentNode.data.equals(data)) {
				previousNode.nextNode = currentNode.nextNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		size--;
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
	
	public void reverse(SinglyLinkedList singlyLinkedList) {
		Node previous = null;
		Node current = singlyLinkedList.headNode;
		Node next = null;
		while(current != null) {
			next = current.nextNode;
			current.nextNode = previous;
			previous = current;
			current = next;
		}
		singlyLinkedList.headNode = previous;
	}
	
	public void detectLoop(SinglyLinkedList singlyLinkedList) {
		Node p = singlyLinkedList.headNode;
		Node q = singlyLinkedList.headNode;
		
		while(p!=null && q!=null && p.nextNode!=null) {
			p = p.nextNode.nextNode;
			q = q.nextNode;
			if(p == q) {
				System.out.println("Loop Detected");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.insertAtHead("a");
		singlyLinkedList.insertAtHead("b");
		singlyLinkedList.insertAtHead("c");
		singlyLinkedList.insertAtEnd("y");
		singlyLinkedList.insertAtEnd("z");
		singlyLinkedList.insertAtHead("1");
		singlyLinkedList.insertAfter("omega", "y");
		singlyLinkedList.insertAfter("theta", "z");
		singlyLinkedList.printList();
		singlyLinkedList.searchNode("omega");
		singlyLinkedList.searchNode("gama");
		singlyLinkedList.deleteAtHead();
		singlyLinkedList.printList();
		singlyLinkedList.deleteAtHead();
		singlyLinkedList.printList();
		System.out.println(singlyLinkedList.size);
		singlyLinkedList.deleteByValue("omega");
		singlyLinkedList.printList();
		System.out.println(singlyLinkedList.size);
		singlyLinkedList.length();
		singlyLinkedList.reverse(singlyLinkedList);
		singlyLinkedList.printList();
		singlyLinkedList.detectLoop(singlyLinkedList);
		singlyLinkedList.insertAtEnd("y");
		singlyLinkedList.printList();
		singlyLinkedList.detectLoop(singlyLinkedList);
	}
}
