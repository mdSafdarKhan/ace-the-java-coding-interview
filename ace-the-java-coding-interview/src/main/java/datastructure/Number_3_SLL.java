package datastructure;

public class Number_3_SLL {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.insertAtHead("a");
		singlyLinkedList.insertAtHead("b");
		singlyLinkedList.insertAtHead("c");
		singlyLinkedList.printList();
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
	
	public void printList() {
		Node temp = headNode;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.nextNode;
		}
	}
}

class Node{
	String data;
	Node nextNode;
}
