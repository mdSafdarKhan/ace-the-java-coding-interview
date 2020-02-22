package datastructure;

public class Number_3_SLL {

	public static void main(String[] args) {
		dllOperations();
		//sllOperations();
	}
	
	public static void dllOperations() {
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
	}
	
	public static void sllOperations() {
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
	}
}

class DoublyLinkedList{
	
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
}
class SinglyLinkedList{
	
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
}
