// Node class for Single Linked List
class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

// SingleLinkedList with head and tail
class SingleLinkedList {
    Node head, tail;

    // Add a node at the beginning
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
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
            tail = null; // If list becomes empty, reset tail
        }
    }

    // Remove a node from the end
    public void removeAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
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

// Test SingleLinkedList with head and tail
public class Sll {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

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

