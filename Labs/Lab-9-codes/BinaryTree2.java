class BinaryTree2 {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public boolean balanceTree(Node root) {
        return checkHeight(root) != -1;
    }


    private int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }


        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);

        System.out.println("Is the tree balanced? " + tree.balanceTree(tree.root)); 
        tree.root.right.right = new Node(20);
        tree.root.right.right.right = new Node(25);

        System.out.println("Is the tree balanced? " + tree.balanceTree(tree.root));
    }
}

