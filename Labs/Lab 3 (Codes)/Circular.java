// Node class for Linked List
class Node {
    int data;      // Data stored in the node
    Node next;     // Reference to the next node in the list

    Node(int data) {
        this.data = data;
        this.next = null; // Initialize next as null when the node is created
    }
}

// LinkedList class with cycle detection method
class LinkedList {
    Node head; // Head node of the linked list

    // Method to detect a cycle in the linked list
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, no cycle exists
        }

        Node slow = head; // Slow pointer starts at the head
        Node fast = head; // Fast pointer starts at the head

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // Cycle detected if both pointers meet
            }
        }

        return false; // No cycle detected if the fast pointer reaches the end of the list
    }

    // Method to add a new node to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If list is empty, new node becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Method to create a cycle for testing purposes
    public void createCycle() {
        if (head == null) return;

        Node current = head;
        Node temp = null;
        int count = 1;
        while (current.next != null) {
            if (count == 2) {
                temp = current; // Set the node to link back to (creating a cycle)
            }
            current = current.next;
            count++;
        }
        current.next = temp; // Create the cycle by pointing the last node to an earlier node
    }
    public class Circular{

    

    // Main method to test the cycle detection
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.createCycle(); // Manually create a cycle for testing

        // Check if the list contains a cycle
        if (list.hasCycle(list.head)) {
            System.out.println("The list contains a cycle.");
        } else {
            System.out.println("The list does not contain a cycle.");
        }
    }
}
}
