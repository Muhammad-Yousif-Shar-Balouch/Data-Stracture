// Node class for Double Linked List
class Node {
    String name;
    Node prev, next;

    Node(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

// DoubleLinkedList with head and tail
class DoubleLinkedList {
    Node head, tail;

    // Add a node at the beginning
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a node at the end
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Remove a node from the beginning
    public void removeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    // Remove a node from the end
    public void removeAtEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Print all nodes
    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Test DoubleLinkedList with head and tail
public class Dlltail {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.insertAtBeginning("A");
        list.insertAtEnd("B");
        list.insertAtEnd("C");
        list.insertAtBeginning("D");

        list.printAll(); // D A B C

        list.removeAtBeginning();
        list.printAll(); // A B C

        list.removeAtEnd();
        list.printAll(); // A B
    }
}

