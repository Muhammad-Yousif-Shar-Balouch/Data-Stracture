import java.util.LinkedList;
public class Linkedlist{
    Node head;

public class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
                current.next = newNode;
            }
            }
           
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void front(int data){
        Node  newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
         newNode.next=head;
         head=newNode;
       // Node n=head;
       // head=newNode;
       // newNode=n;
    }
    public static void main(String[] args) {
        Linkedlist ll= new Linkedlist();
        ll.front(5);
        ll.front(7);
        ll.front(10);
        
        ll.insert(4);
        ll.insert(9);
       
       
        
        
        
        ll.display();
    }
}
