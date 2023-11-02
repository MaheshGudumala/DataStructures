class Node{
	Node prev;
	int value;
	Node next;
	Node(){}
	Node (int value){
		this.value = value;
	}
}
public class DoublyLinkedList{
	Node head;
	DoublyLinkedList(){
		head = null;
	}
	boolean isEmpty(){
		return head == null;
	}
	void insertAtStart(int value){
		//todo
		Node node = new Node(value);
		if(isEmpty()){
			head = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
	void insertAtEnd(int value){
		//todo
		Node node = new Node(value);
		if(!isEmpty()){
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
			node.prev = temp;
		} else {
			head = node;
		}
	}
	int deleteFromStart(){
		if(isEmpty()) return -1;
		int result;
		result = head.value;
		head = head.next;
		return result;
	}
	int deleteFromEnd(){
		if(isEmpty()) return -1;
		int result;
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		result = temp.value;
		if(temp.prev != null){
			temp.prev.next = null;
		} else {
			head = null;
		}
		return result;
	}
	void display(){
		if(isEmpty()) return;
		Node temp = head;
		while(temp != null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.display();
		doublyLinkedList.insertAtEnd(3);
		doublyLinkedList.display();
		doublyLinkedList.insertAtEnd(4);
		doublyLinkedList.display();
		doublyLinkedList.insertAtStart(2);
		doublyLinkedList.display();
		doublyLinkedList.insertAtEnd(5);
		doublyLinkedList.display();
		doublyLinkedList.insertAtStart(1);
		doublyLinkedList.display();
		doublyLinkedList.deleteFromStart();
		doublyLinkedList.display();
		doublyLinkedList.deleteFromEnd();
		doublyLinkedList.display();
		doublyLinkedList.deleteFromEnd();
		doublyLinkedList.display();
		doublyLinkedList.deleteFromStart();
		doublyLinkedList.display();
	}
}
