class BinaryTree {

    Node root;


    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public void addNode(int data) {
        root = addNodeRecursive(root, data);
    }

    private Node addNodeRecursive(Node current, int data) {
        if (current == null) {

            return new Node(data);
        }

        if (data < current.data) {
            current.left = addNodeRecursive(current.left, data);
        } else if (data > current.data) {

            current.right = addNodeRecursive(current.right, data);
        } else {

            System.out.println("Duplicate values are not allowed in this Binary Search Tree.");
        }

        return current;
    }


    public boolean searchNode(int data) {
        return searchNodeRecursive(root, data);
    }

    private boolean searchNodeRecursive(Node current, int data) {
        if (current == null) {

            return false;
        }

        if (data == current.data) {

            return true;
        }

        return data < current.data
                ? searchNodeRecursive(current.left, data)
                : searchNodeRecursive(current.right, data);
    }


    public int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countOfNodes(root.left) + countOfNodes(root.right);
    }


    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();


        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(15);
        tree.addNode(3);
        tree.addNode(7);


        System.out.println("Is 7 in the tree? " + tree.searchNode(7));
        System.out.println("Is 8 in the tree? " + tree.searchNode(8));


        System.out.println("Total number of nodes: " + tree.countOfNodes(tree.root));


        System.out.println("Height of the tree: " + tree.height(tree.root));
    }
}
