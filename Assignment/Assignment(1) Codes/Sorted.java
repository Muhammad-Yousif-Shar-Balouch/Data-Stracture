
class Node {
    int data;
    Node next;


    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head;


    public void insert(int data) {
        Node newNode = new Node(data);


        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void sort() {

        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        Node current = head;
        Node index = null;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }


    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


public class Sorted {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(50);
        list.insert(70);
        list.insert(35);
        list.insert(28);
        list.insert(19);

        System.out.println("Original Linked List:");
        list.display();


        list.sort();


        System.out.println("Sorted Linked List:");
        list.display();
    }
}

