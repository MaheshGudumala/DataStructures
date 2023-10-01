
public class Queue {
	public class Node{	//each element on Queue
		int data;	//value of each element
		Node next = null;	//pointer to front element
		Node(int data){
			this.data = data;
		}
	}
	public Node head = null;	//head pointer to remove elements from
	public Node tail = null;	//tail pointer to add elements to
	public boolean isEmpty() {	//checks whether the queue is empty
		return head == null;
	}
	public void offer(int data) {	//adds element to the tail of the queue
		Node newNode = new Node(data);
		if(isEmpty()) {
			tail = head = newNode;
			head.next = null;
			tail.next = null;
		}
		else {
			newNode.next = tail;
			tail = newNode;
		}
	}
	public void poll() {	//removes element from the head of the queue
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		else if (head == tail) {
			head = tail = null;
		}
		else {
			Node currentNode = tail;
			while(currentNode.next != head) {
				currentNode = currentNode.next;
			}
			currentNode.next =null;
			head = currentNode;
		}
	}
	public void display() {	//displays all the elements on the queue
		if(isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			Node currentNode = tail;
			while(currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue q = new Queue();
		//do your operations on the Queue here
		q = null;
		System.gc();
	}

}
