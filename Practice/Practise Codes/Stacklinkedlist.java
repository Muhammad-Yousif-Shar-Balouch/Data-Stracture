public class Stacklinkedlist {
    // Define Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node of the linked list
    private Node head;

    // Constructor for Stacklinkedlist
    public Stacklinkedlist() {
        this.head = null;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Push element to the stack
    public void push(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Link the new node to the current head
        head = newNode; // Make the new node the new head
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1; // Return -1 to indicate empty stack
        }
        int top = head.data; // Get the data from the head node
        head = head.next; // Move the head to the next node
        return top; // Return the popped data
    }

    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return head.data; // Return the data from the head node
    }

    public static void main(String[] args) {
        Stacklinkedlist stack = new Stacklinkedlist(); // Create a stack

        // Push elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop an element
        System.out.println("Popped: " + stack.pop()); // Should print "Popped: 3"

        // Print all elements in the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print the top element
            stack.pop(); // Pop the top element
        }
    }
}
