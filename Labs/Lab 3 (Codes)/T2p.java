public class T2p {
    Node head;
    Node tail;
    int size; 

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public T2p() {
        size = 0;
    }


    public void Addfirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
        size++; 
    }

    // Add node at the end
    public void Addlast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        size++; // Increment size
    }

    // Remove node from the beginning
    public void Removefirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--; // Decrement size
    }

    // Remove node from the end
    public void Removelast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--; // Decrement size
    }

    // Print the list
    public void Print() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Print the size of the list
    public void PrintSize() {
        System.out.println("Size of the list: " + size);
    }

    public static void main(String[] args) {
        T2p t = new T2p();
        t.Addfirst(2);
        t.Addfirst(3);
        t.Addfirst(1);
        t.Addlast(4);
        t.Addlast(5);
        t.Addlast(6);
        t.Removefirst();
        t.Removelast();
        t.Print();
        t.PrintSize(); // Print the size of the list
    }
}

