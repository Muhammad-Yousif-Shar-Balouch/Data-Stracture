
class Node {
    int data;
    Node next;


    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head;

    
    public void insert(int data) {
        Node newNode = new Node(data);

    
        if (head == null) {
            head = newNode;
        } else {
            
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    
    public void reverse() {
        
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;  
            current.next = prev;  
            prev = current;       
            current = next;       
        }
        head = prev;  
    }

    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


public class R {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        
        list.insert(50);
        list.insert(40);
        list.insert(30);
        list.insert(20);
        list.insert(10);

        
        System.out.println("Original Linked List:");
        list.display();

        
        list.reverse();

    
        System.out.println("Reversed Linked List:");
        list.display();
    }
}
