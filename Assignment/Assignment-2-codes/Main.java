
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
        int count = 1;
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


public class Main {
    public static void main(String[] args) {
        
        LinkedList<Integer> intList = new LinkedList<>();
     
        intList.display();  
         intList.addFirst(10);
        intList.addLast(20);
        intList.addFirst(5);
        intList.addMiddle(1, 15);
        intList.display();  
         intList.addFirst(11);
        intList.addLast(29);
        intList.addFirst(52);
        intList.addMiddle(4, 9);
        intList.removeFirst();
       intList.removeLast();
       intList.display();

        
        intList.removeMiddle(1);
        intList.display();

        
        intList.reverse();
        System.out.println("Reversed list:");
       intList.display();

        
        intList.removeDuplicates();
        System.out.println("After removing duplicates:");
        intList.display();

        
        System.out.println("Search for 15: " + intList.search(15));

        
        System.out.println("Is empty: " + intList.isEmpty());

        
        System.out.println("Length: " + intList.length());


        LinkedList<String> strList = new LinkedList<>();
        strList.addFirst("Hello");
        strList.addFirst("Welcome");
        strList.addLast("World");
        strList.addMiddle(1, "Java");
        strList.display();

        strList .removeFirst();
        strList.removeLast();
        strList.display();
 
         
        strList.removeMiddle(1);
        strList.display();
 
         
        strList.reverse();
         System.out.println("Reversed list:");
         strList.display();
 
         
         strList.removeDuplicates();
         System.out.println("After removing duplicates:");
         strList.display();
 
         
         System.out.println("Search for 15: " +   strList.search("o"));
 
         
         System.out.println("Is empty: " +   strList.isEmpty());
 
         
         System.out.println("Length: " +   strList.length());

        LinkedList<Double> doubleList = new LinkedList<>();
        doubleList.addFirst(7.9);
        doubleList.addLast(8.12);
        doubleList.addMiddle(2, 4.3);
        doubleList.display();
        doubleList .removeFirst();
        doubleList .removeLast();
        doubleList .display();

        
        doubleList .removeMiddle(1);
        doubleList .display();

        
        doubleList  .reverse();
        System.out.println("Reversed list:");
        doubleList .display();

        
        doubleList .removeDuplicates();
        System.out.println("After removing duplicates:");
        doubleList .display();

        
        System.out.println("Search for 15: " +  doubleList.search(8.12));

        
        System.out.println("Is empty: " + doubleList .isEmpty());

        
        System.out.println("Length: " + doubleList .length());










    }
}
