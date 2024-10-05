class Node {
    int data;
    Node next;


    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linkedlistcycle {


    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        // Example 1: No cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Does it have a cycle? " + hasCycle(head));

        // Example 2: Create a cycle
        Node headWithCycle = new Node(1);
        headWithCycle.next = new Node(2);
        headWithCycle.next.next = new Node(3);
        headWithCycle.next.next.next = headWithCycle.next;

        System.out.println("Does it have a cycle? " + hasCycle(headWithCycle));
    }
}

