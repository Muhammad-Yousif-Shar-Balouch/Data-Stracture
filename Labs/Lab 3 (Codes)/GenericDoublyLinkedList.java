public class GenericDoublyLinkedList<T> {
    
    class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head, tail;
    private int size;

    public GenericDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    
    public void addMiddle(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
            size++;
        }
    }

    
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T removedData = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedData;
    }

    
    public T removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        T removedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedData;
    }

    
    public T removeMiddle(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            T removedData = temp.next.data;
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.prev = temp;
            }
            size--;
            return removedData;
        }
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
        GenericDoublyLinkedList<Integer> list = new GenericDoublyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addMiddle(1, 15);
        list.printList();

        list.removeFirst();
        list.removeLast();
        list.printList();

        System.out.println("Size: " + list.size());
    }
}

