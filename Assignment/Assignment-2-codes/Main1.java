 

class LinkedList<T> {
    
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    
    public boolean isEmpty() {
        return head == null;
    }

    
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    
    public void addLast(T data) {
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

    
    public void addMiddle(int position, T data) {
        if (position <= 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    
    public void removeMiddle(int position) {
        if (position <= 0 || head == null) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current != null && current.next != null; i++) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    
    public boolean search(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data.equals(runner.next.data)) {
                    runner.next = runner.next.next; 
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


public class Main1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        
        list.addFirst(10);
        list.addLast(20);
        list.addLast(20); 
        list.addFirst(5);
        list.addMiddle(2, 15);

        
        list.display();

        
        list.removeFirst();
        list.removeLast();
        list.display();

        
        list.removeMiddle(1);
        list.display();

        
        list.reverse();
        System.out.println("Reversed list:");
        list.display();

        
        list.removeDuplicates();
        System.out.println("After removing duplicates:");
        list.display();

        
        System.out.println("Search for 15: " + list.search(15));

        
        System.out.println("Is empty: " + list.isEmpty());

        
        System.out.println("Length: " + list.length());
    }
}

