public class BinaryTree1 {
        Node root;
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
                left = right = null;
            }
        }

        public int minNumber(Node root) {
            if (root == null) {
                throw new IllegalArgumentException("Tree is empty");
            }

            int min = root.data;

            if (root.left != null) {
                min = Math.min(min, minNumber(root.left));
            }
            if (root.right != null) {
                min = Math.min(min, minNumber(root.right));
            }
            return min;
        }
        public int maxNumber(Node root) {
            if (root == null) {
                throw new IllegalArgumentException("Tree is empty");
            }

            int max = root.data;

            if (root.left != null) {
                max = Math.max(max, maxNumber(root.left));
            }
            if (root.right != null) {
                max = Math.max(max, maxNumber(root.right));
            }

            return max;
        }

        public static void main(String[] args) {
            BinaryTree1 tree = new BinaryTree1();
            tree.root = new Node(10);
            tree.root.left = new Node(5);
            tree.root.right = new Node(15);
            tree.root.left.left = new Node(3);
            tree.root.left.right = new Node(7);
            tree.root.right.right = new Node(20);

            System.out.println("Minimum value in the tree: " + tree.minNumber(tree.root));
            System.out.println("Maximum value in the tree: " + tree.maxNumber(tree.root));
        }
    }

