
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


    public int length() {
        int count = 0;
        Node current = head;


        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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


public class L {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        
        list.insert(100);
        list.insert(200);
        list.insert(30);
        list.insert(40);

    
        System.out.println("Linked List:");
        list.display();

        
        int length = list.length();
        System.out.println("Length of the linked list: " + length);
    }
}
