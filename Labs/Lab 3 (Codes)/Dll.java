 class Node{
    String name;
    Node prev,next;
    Node(String name){
        this.name=name;
        this.prev=null;
        this.next=null;
    }

}
public class Dll{
    Node head;

    public void Addfirst(String name){
        Node newnode= new Node(name);
        if(head==null){
            head= newnode;
        }
        else{
            newnode.next=head;
            head.prev= newnode;
            head= newnode;
        }
    }

    public void Addfirst(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }


    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }


    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
        }
    }


    public void insertAfterName(String name, Node node) {
        Node current = head;
        while (current != null && !current.name.equals(name)) { 
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with name '" + name + "' not found.");
        } else {
            node.next = current.next;
            node.prev = current;
            if (current.next != null) {
                current.next.prev = node;
            }
            current.next = node;
        }
    }


    public void insertBeforeName(String name, Node node) {
        Node current = head;
        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with name '" + name + "' not found.");
        } else {
            node.next = current;
            node.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = node;
            } else {
                head = node;
            }
            current.prev = node;
        }
    }


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


    public void printAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.name + " ");
            current = current.next;
        } while (current != null && current != head); 
        System.out.println();
    }

    // Test the class
    public static void main(String[] args) {
        Dll list = new Dll();

        list.Addfirst("A");
        list.insertAtEnd("B");
        list.insertAtEnd("C");
        list.Addfirst("D");

        list.printAll();

        list.insertAfterName("A", new Node("E"));
        list.insertBeforeName("C", new Node("F"));

        list.printAll();

        list.makeCircular();
        list.printAll();
    }
}



