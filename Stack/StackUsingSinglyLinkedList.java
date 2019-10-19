package javaselflearning;

public class Stack {
	public class Node{	//each element on the stack
		int data;	//data of the element
		Node next = null;	//pointer to element under present element
		Node(int data){
			this.data = data;	//constructor to initialise the element
		}
	}
	public Node top = null;	//top of stack set to null
	public void push(int data) {	//pushing element on to the top of the stack
		Node newNode = new Node(data);
		if(isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}
	public void pop() {	//popping element from the top of the stack
		if(isEmpty()) {
			System.out.println("stack is empty!");
		} else {
			top = top.next;
		}
	}
	public int peek() {	//returns the top of stack
		if(isEmpty()) {
			System.out.println("stack is empty!");
			return -1;
		} else {
			return top.data;
		}
	}
	public void display() {	//displaying elements of the stack
		Node currentNode = top;
		if(isEmpty()) {
			System.out.println("stack is empty!");
		} else {
			while(currentNode!= null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
		System.out.println();
		currentNode = null;
	}
	public boolean isEmpty() {	//checking if stack is empty
		if(top == null)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		//do your operations on stack here
		stack = null;
		System.gc();
	}

}
