public class CompleteBinaryTree {

    // A simple Node class to represent each node of the tree
    static class Node {
        int data; // Data in the node
        Node left, right; // Left and right children

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            left = right = null; // Initially, no children
        }
    }

    private Node root; // Root of the tree
    private int size; // Keeps track of the number of nodes

    // Constructor
    public CompleteBinaryTree() {
        root = null; // Tree starts empty
        size = 0; // No nodes initially
    }

    // Insert method to add new node
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode; // If the tree is empty, this new node becomes the root
        } else {
            // Use a queue to help insert the node in the right position
            java.util.Queue<Node> queue = new java.util.LinkedList<>();
            queue.add(root);

            // Traverse the tree to find the first empty spot
            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode; // Insert the new node here
                    break;
                } else {
                    queue.add(current.left); // Otherwise, go to the left child
                }

                if (current.right == null) {
                    current.right = newNode; // Insert the new node here
                    break;
                } else {
                    queue.add(current.right); // Otherwise, go to the right child
                }
            }
        }

        size++; // Increment the size of the tree
    }

    // Check if the tree is complete
    public boolean isComplete() {
        if (root == null) return true; // An empty tree is complete

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        boolean flag = false; // Flag to check if we encountered a missing child

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                if (flag) return false; // If we encountered a missing child before, the tree is not complete
                queue.add(current.left); // Add the left child to the queue
            } else {
                flag = true; // We have an empty left child
            }

            if (current.right != null) {
                if (flag) return false; // If we encountered a missing child before, the tree is not complete
                queue.add(current.right); // Add the right child to the queue
            } else {
                flag = true; // We have an empty right child
            }
        }
        return true; // If no issues, the tree is complete
    }

    // Print the tree in level-order (breadth-first)
    public void printLevelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " "); // Print the current node

            // Add left and right children to the queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // Get the size of the tree (number of nodes)
    public int getSize() {
        return size;
    }

    // Main method to test the tree
    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        // Insert nodes into the tree
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        // Print the tree in level-order
        System.out.println("Level Order Traversal:");
        tree.printLevelOrder(); // Output should be 1 2 3 4 5 6 7

        // Check if the tree is complete
        System.out.println("Is the tree complete? " + tree.isComplete()); // Should return true

        // Print the size of the tree
        System.out.println("Size of the tree: " + tree.getSize()); // Should return 7
    }
}

