public class DoublyLinkedList {
	public int size = 0;
	public class Node{
		int data;
		Node prev;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	public Node head = null;
	public Node tail = null;
	public void insertBegin(int data) {
		size++;
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			head.prev = null;
		}
	}
	public void insertMid(int position, int data) {
		if(position <= size && position > 0) {
			Node newNode = new Node(data);
			if(position == 1) {
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
				head.prev = null;
			}
			else if(position == size) {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
				tail.next = null;
			}
			else {
				int i = 1;
				Node currentNode = head;
				while(i < position) {
					currentNode = currentNode.next;
					i++;
				}
				newNode.next = currentNode;
				newNode.prev = currentNode.prev;
				currentNode.prev.next = newNode;
				currentNode.prev = newNode;
			}
		}
	}
	public void insertEnd(int data) {
		size++;
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
		}
	}
	public void deleteBegin() {
		if(head == null) {
			System.out.println("No elements to delete");
		} else {
			head = head.next;
			head.prev = null;
			size--;
		}
		
	}
	public void deleteMid(int position) {
		Node currentNode = head;
		if(head == null) {
			System.out.println("No elements to delete");
		}
		else if(position <= size && position > 0) {
			if(position == 1) {
				head = head.next;
				head.prev = null;
				size--;
			}
			else if(position == size) {
				tail = tail.prev;
				tail.next = null;
				size--;
			}
			else {
				int i = 1;
				while(i < position) {
					currentNode = currentNode.next;
					i++;
				}
				currentNode.prev.next = currentNode.next;
				currentNode.next.prev = currentNode.prev;
				currentNode = null;
			}
		}
	}
	public void deleteEnd() {
		if(head == null) {
			System.out.println("No elements to delete");
		} else {
			tail = tail.prev;
			tail.next = null;
			size--;
		}
	}
	public void displayfromBegin() {
		Node currentNode = head;
		if(size == 0) {
			System.out.println("No list elements");
		}
		else {
			while(currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}
	public void displayfromEnd() {
		Node currentNode = tail;
		if(size == 0) {
			System.out.println("No list elements");
		}
		else {
			while(currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.prev;
			}
		}
	}
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		//do your operations here with the list 
		list = null;
		System.gc();
	}

}
