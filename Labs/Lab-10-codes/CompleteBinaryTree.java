import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public CompleteBinaryTree() {
        this.root = null;
        this.size = 0;
    }


    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    queue.add(current.left);
                }

                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    queue.add(current.right);
                }
            }
        }
        size++;
    }


    public boolean isComplete() {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean noMoreChildrenAllowed = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                if (noMoreChildrenAllowed) return false;
                queue.add(current.left);
            } else {
                noMoreChildrenAllowed = true;
            }

            if (current.right != null) {
                if (noMoreChildrenAllowed) return false;
                queue.add(current.right);
            } else {
                noMoreChildrenAllowed = true;
            }
        }
        return true;
    }


    public void printLevelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }


    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(9);
        tree.root.left.right = null;
        System.out.println("Level Order Traversal:");
        tree.printLevelOrder();
        System.out.println("Is the tree complete? " + tree.isComplete());
        System.out.println("Size of the tree: " + tree.getSize());
    }
}
