import java.util.*;

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


public  void preorder(Node root){
    if(root==null){
        return ;
    }
    System.out.println(root.data+" --->");
    preorder(root.left);
    preorder(root.right);

}
public void postorder(Node root){
    if(root==null){
        return ;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.println(root.data+"--->  ");
}
public void inorder(Node root){
    if(root==null){
        return;
    }
    inorder(root.left);
    System.out.println(root.data+"--->");
    inorder( root.right);
}

public void levelorder(Node root){
    if(root==null){
        System.out.println("Tree is Empty");
        return;
    }
    Queue<Node> queue = new LinkedList<>(); 
    queue.add(root); 
    while(!queue.isEmpty()){
        Node current=queue.poll();
        System.out.println(current.data+"--->");
        if(current.left!=null){
            queue.add(current.left);
        }
        if(current.right!=null){
            queue.add(current.right);
        }
    }
}


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(15);
        tree.addNode(3);
        tree.addNode(7);

        System.out.println("Is 7 in the tree? " + tree.searchNode(7));  // Output: true
        System.out.println("Is 8 in the tree? " + tree.searchNode(8));  // Output: false
        System.out.println("Total number of nodes: " + tree.countOfNodes(tree.root));  // Output: 5
        System.out.println("Height of the tree: " + tree.height(tree.root));  // Output: 3
      //  System.out.println("This is Preorder");
       // tree.preorder(tree.root);
       // System.out.println("This is postorder");
       // tree.postorder(tree.root);
       // System.out.println("This is inorder");
      //  tree.inorder(tree.root);

      System.out.println("Level Order Traversal:");
      tree.levelorder(tree.root); 






    }
}

