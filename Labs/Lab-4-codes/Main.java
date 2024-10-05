// Class for queue
class Queue {
    private int arr[];    // Array to store queue elements
    private int front;    // Front points to the front element in the queue
    private int rear;     // Rear points to the last element in the queue
    private int capacity; // Maximum capacity of the queue
    private int count;    // Current size of the queue

    // Constructor to initialize the queue
    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;  // Rear starts before the first element
        count = 0;  // Queue is initially empty
    }

    // Utility function to remove front element from the queue and check for Queue Underflow
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return;
        }
        System.out.println("Removing " + arr[front]);

        // Move the front pointer to the next element
        front = (front + 1) % capacity;
        count--; // Decrease the count of elements
    }

    // Utility function to add an item to the queue and check for Queue Overflow
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue.");
            return;
        }

        // Move rear to the next position (circular queue)
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++; // Increase the count of elements
        System.out.println("Inserted " + item);
    }

    // Utility function to return front element in the queue and check for Queue Underflow
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element.");
            return -1;
        }
        return arr[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        return count == 0;
    }

    // Utility function to check if the queue is full or not
    public Boolean isFull() {
        return count == capacity;
    }
}

// Main class to test the queue
class Main {
    public static void main(String[] args) {
        // Create a queue of capacity 5
        Queue q = new Queue(5);

        q.enqueue(1);   // Insert 1
        q.enqueue(2);   // Insert 2
        q.enqueue(3);   // Insert 3

        System.out.println("Front element is: " + q.peek()); // Should print 1
        q.dequeue();    // Remove 1
        System.out.println("Front element is: " + q.peek()); // Should print 2

        System.out.println("Queue size is " + q.size()); // Should print 2

        q.dequeue();    // Remove 2
        q.dequeue();    // Remove 3

        // Check if the queue is empty
        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");
    }
}

