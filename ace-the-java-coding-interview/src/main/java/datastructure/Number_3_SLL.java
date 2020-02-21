package datastructure;

public class Number_3_SLL {

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
	}
}

class SinglyLinkedList{
	
	Node headNode;
	
	public SinglyLinkedList() {
		headNode = null;
	}
	
	public void insertAtHead(String data) {
		Node node = new Node();
		node.data = data;
		node.nextNode = headNode;
		headNode = node;
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
	
	public void printList() {
		Node temp = headNode;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.nextNode;
		}
		System.out.println(temp);
	}
}

class Node{
	String data;
	Node nextNode;
}
