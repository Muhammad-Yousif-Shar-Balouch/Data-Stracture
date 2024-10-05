public class T2d {
    Node head;
    Node tail;
    int size;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public T2d() {
        size = 0;
    }

    public void Addfirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        size++;
    }

    public void Addlast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        size++;
    }

    public void Removefirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void Removelast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

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

    public void PrintSize() {
        System.out.println("Size of the list: " + size);
    }

    public static void main(String[] args) {
        T2d t = new T2d();

        t.Addfirst(2);
        t.print();
        t.Addfirst(3);
        t.print();

        t.Addfirst(1);
        t.print();

        t.Addlast(4);
        t.print();
        t.Addlast(5);
        t.print();

        t.Addlast(6);
        t.Addlast(7);
        t.print();

        t.Removelast();
        t.print();
        t.Removelast();
        t.print();

        t.Removefirst();
        t.print();
        t.Removefirst();
        t.print();

        t.PrintSize();
    }
}
