public class BST {

static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public  boolean isidentical(Node root1, Node root2){
        if(root1==null && root2==null ){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return(root1.data== root2.data)&&
        isidentical(root1.left, root2.left)&&
        isidentical(root1.right, root2.right);


    }


    public boolean isSubTree(Node root1, Node root2){
        if(root2== null){
            return true;
        }
        if(root1== null){
            return false;
        }
        if(isidentical(root1, root2)){
            return true;
        }
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
    public static void main(String[] args) {
        BST t= new BST();
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        
        Node root2 = new Node(3);
        root2.left = new Node(6);
        root2.right = new Node(7);

    
        System.out.println("Are the trees identical? " + t.isidentical(root1, root2));
       // root1.right.data=4;
        root2.right.data = 4;

        System.out.println("Are the trees identical? " + t.isidentical(root1, root2)); 
        System.out.println("Is the second tree a subtree of the first? " + t.isSubTree(root1, root2));
    }
}
    





