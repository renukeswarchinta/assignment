package interviewQuestions;

public class LinkedListImpl {
	Node head;
	public LinkedListImpl insertNode(LinkedListImpl list , int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if(list.head == null) {
			list.head = newNode;
		}else {
			// traverse till last 
			Node nextElement = list.head;
			while(nextElement.next != null) {
				nextElement = nextElement.next;
			}
			nextElement.next = newNode;
		}
		return list;
	}
	public void isLinkedListCyclic(LinkedListImpl list){
		Node next = list.head;
		while(next.next == null) {
			next = next.next;
		}
		if(next == head) {
			System.out.println("it is cyclic");
		}
	}
	
}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next =null;
	}
}