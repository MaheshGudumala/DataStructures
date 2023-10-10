class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class List{
    private Node head;

    public List(int data){
        head = new Node(data);
    }

    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public boolean delete(int data){
        if(head == null) return false;
        if(head.data == data){
            head = head.next;
            return true;
        }
        Node prev = head;
        Node temp = prev.next;
        while(temp != null){
            if(temp.data == data){
                prev.next = temp.next;
                return true;
            }
            prev = prev.next;
            temp = prev.next;
        }
        return false;
    }

    public void display(){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class LinkedList {

    public static void main(String[] args) {
        List list = new List(0);
        System.out.println(list.delete(1));
        list.display();
        list.insert(1);
        list.display();
        System.out.println(list.delete(1));
        list.insert(2);
        list.display();
        list.insert(3);
        list.display();
        list.insert(4);
        list.display();
        System.out.println(list.delete(4));
        list.display();
        System.out.println(list.delete(0));
        list.display();
        list.insert(5);
        list.display();
        System.out.println(list.delete(3));
        list.display();
        System.out.println(list.delete(2));
        list.display();
        System.out.println(list.delete(5));
        list.display();
        System.out.println(list.delete(5));
        list.display();
        list.insert(1);
        list.display();
    }
}
