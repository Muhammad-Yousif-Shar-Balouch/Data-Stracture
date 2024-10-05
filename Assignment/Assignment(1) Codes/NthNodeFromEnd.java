// Node class representing each element in the linked list
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    Node head;

    // Function to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list and insert the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Function to get the nth node from the end of the linked list
    public int nthFromLast(int n) {
        // Case-1: List is empty
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return -1; // Use -1 as a flag for an empty list
        }

        Node mainPtr = head;
        Node refPtr = head;

        // Move refPtr n nodes ahead
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                System.out.println("n is greater than the number of nodes in the list");
                return -1; // Use -1 as a flag for an invalid input
            }
            refPtr = refPtr.next;
            count++;
        }

        // Move both pointers until refPtr reaches the end
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        // mainPtr now points to the nth node from the end
        return mainPtr.data;
    }

    // Function to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to test the LinkedList implementation
public class NthNodeFromEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting elements into the linked list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        // Display the list
        System.out.println("Linked List:");
        list.display();

        // Finding the nth node from the end
        int n = 2;
        int result = list.nthFromLast(n);
        if (result != -1) {
            System.out.println("The " + n + "th node from the end is: " + result);
        }
    }
}
