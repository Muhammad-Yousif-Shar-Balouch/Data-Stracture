public class GenericSinglyLinkedList<T> {
    
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public GenericSinglyLinkedList() {
        head = null;
        size = 0;
    }

    
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    
    public void addMiddle(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }


    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    
    public T removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            T removedData = head.data;
            head = null;
            size--;
            return removedData;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T removedData = temp.next.data;
        temp.next = null;
        size--;
        return removedData;
    }

    
    public T removeMiddle(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            return removeFirst();
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        T removedData = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return removedData;
    }

    
    public int size() {
        return size;
    }

    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericSinglyLinkedList<Integer> list = new GenericSinglyLinkedList<>();
        list.addFirst(102);
        list.addLast(209);
        list.addMiddle(2, 900);
        list.printList(); 

        list.removeFirst();
        list.removeLast();
        list.printList(); 

        System.out.println("Size: " + list.size());
    }
}
