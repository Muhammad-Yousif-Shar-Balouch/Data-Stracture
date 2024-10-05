public class Circularlinkedlist {
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

    public Circularlinkedlist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void Addfirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }


    public void Addlast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; 
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
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
            tail.next = head;
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
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head; 
        }
        size--;
    }


    public void print() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }


    public void PrintSize() {
        System.out.println("Size of the list: " + size);
    }

    public static void main(String[] args) {
        Circularlinkedlist cll = new Circularlinkedlist();

        cll.Addfirst(2);
        cll.print();
        cll.Addfirst(3);
        cll.print();

        cll.Addfirst(1);
        cll.print();

        cll.Addlast(4);
        cll.print();
        cll.Addlast(5);
        cll.print();

        cll.Addlast(6);
        cll.Addlast(7);
        cll.print();

        cll.Removelast();
        cll.print();
        cll.Removelast();
        cll.print();

        cll.Removefirst();
        cll.print();
        cll.Removefirst();
        cll.print();

        cll.PrintSize();
    }
}

