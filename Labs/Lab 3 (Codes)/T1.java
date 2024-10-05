public class T1 {

    // Inner class to represent a Node in the doubly linked list
    class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.prev = null;
            this.next = null;
            this.name = name;
        }
    }

    // Class representing the Doubly Linked List (Dll)
    public class Dll {
        Node head;

        // Add node at the beginning of the list
        public void Addfirst(String name) {
            Node newnode = new Node(name);
            if (head == null) {
                head = newnode;
            } else {
                newnode.next = head;
                head.prev = newnode;
                head = newnode;
            }
        }

        // Add a node at the end of the list
        public void Addlast(String name) {
            Node newnode = new Node(name);
            if (head == null) {
                head = newnode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }

        // Add node after a specific node by name
        public void AddafterName(String name, Node node) {
            Node temp = head;
            while (temp != null && !temp.name.equals(name)) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Node with name " + name + " not found");
                return;
            }
            node.next = temp.next;
            node.prev = temp;

            if (temp.next != null) {
                temp.next.prev = node;
            }
            temp.next = node;
        }

        // Add node before a specific node by name
        public void AddBeforeName(String name, Node node) {
            Node temp = head;
            while (temp != null && !temp.name.equals(name)) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Node with name " + name + " not found");
                return;
            }
            node.next = temp;
            node.prev = temp.prev;

            if (temp.prev != null) {
                temp.prev.next = node;
            } else {
                head = node;
            }
            temp.prev = node;
        }

        // Make the doubly linked list circular
        public void makeCircular() {
            if (head == null) {
                return;
            }
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = head;
            head.prev = tail;
        }

        // Print the list from start to end
        public void Print() {
            Node temp = head;
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            while (temp != null) {
                System.out.print(temp.name + " -> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    // Main method to test all the methods
    public static void main(String[] args) {
        T1 outer = new T1();  // Create instance of outer class
        Dll list = outer.new Dll();  // Create instance of inner class

        // Testing Addfirst
        list.Addfirst("c");
        list.Addfirst("b");
        list.Addfirst("a");

        list.Print();  // Output: a -> b -> c -> Null

        // Testing Addlast
        list.Addlast("d");
        list.Print();  // Output: a -> b -> c -> d -> Null

        // Testing AddafterName
        Node newNode = outer.new Node("e");
        list.AddafterName("c", newNode);
        list.Print();  // Output: a -> b -> c -> e -> d -> Null

        // Testing AddBeforeName
        Node newNode2 = outer.new Node("x");
        list.AddBeforeName("b", newNode2);
        list.Print();  // Output: a -> x -> b -> c -> e -> d -> Null

        // Testing makeCircular (This will make the list circular but we can't print it directly anymore)
        list.makeCircular();
        System.out.println("List has been made circular");
        // You won't be able to print a circular list normally, as it will keep looping infinitely.
    }
}
