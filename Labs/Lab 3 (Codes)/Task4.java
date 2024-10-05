public class Task4 {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add node at the beginning
    public void Addfirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
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
    }

    // Remove node from the beginning
    public void Removefirst() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
    }

    // Remove node from the end
    public void Removelast() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    // Print the list
    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Task4 t = new Task4();
        t.Addfirst(2);
        t.Addfirst(6);
        t.Addfirst(7);
        t.Addfirst(4);
        t.Addlast(3);
        t.Addlast(9);
        t.Addlast(5);
         t.Removefirst();
         t.Removefirst();
         t.Removelast();
        t.print();
    }
}
