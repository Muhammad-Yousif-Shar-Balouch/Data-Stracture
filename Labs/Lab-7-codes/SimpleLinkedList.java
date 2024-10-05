import java.util.Scanner;

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

    
    public void addNodeback(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    
    public void Iterative() {
        Node temp = head;
        System.out.print("Iterative: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    public void Recursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        Recursive(node.next);
    }

    public void printRecursiveWrapper() {
        System.out.print("Recursive: ");
        Recursive(head);
        System.out.println();
    }
}

public class SimpleLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

    
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

    
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = scanner.nextInt();
            list.addNodeback(value);
        }

        // Measure time for iterative approach
        long startTimeIterative = System.nanoTime();
        list.Iterative();
        long endTimeIterative = System.nanoTime();
        long iterativeTime = endTimeIterative - startTimeIterative;

        // Measure time for recursive approach
        long startTimeRecursive = System.nanoTime();
        list.printRecursiveWrapper();
        long endTimeRecursive = System.nanoTime();
        long recursiveTime = endTimeRecursive - startTimeRecursive;

        // Time comparison
        System.out.println("Time taken by Iterative approach: " + iterativeTime + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + recursiveTime + " nanoseconds");

        if (iterativeTime < recursiveTime) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }

        scanner.close();
    }
}

