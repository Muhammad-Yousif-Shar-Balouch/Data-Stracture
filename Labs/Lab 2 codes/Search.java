
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


    public boolean search(int key) {
        Node current = head;


        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
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


public class Search {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(20);
        list.insert(40);
        list.insert(30);
        list.insert(60);

    
        System.out.println("Linked List:");
        list.display();


        int key = 70;
        if (list.search(key)) {
            System.out.println(key + " found in the list.");
        } else {
            System.out.println(key + " not found in the list.");
        }
    }
}
