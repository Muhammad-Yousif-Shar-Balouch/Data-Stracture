public class Stackusingtwoqueues extends QueueLinkedlist {
    
    
    QueueLinkedlist q1 = new QueueLinkedlist();
    QueueLinkedlist q2 = new QueueLinkedlist(); 


    public void push(int data) {
        q1.Enqueue(data);
        System.out.println("Pushed -> " + data);
    }

    
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

    
        while (q1.size > 1) {
            q2.Enqueue(q1.DeQueue());
        }

        
        int poppedElement = q1.DeQueue();

    
        QueueLinkedlist temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println("Popped -> " + poppedElement);
        return poppedElement;
    }

    
    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        
        while (q1.size > 1) {
            q2.Enqueue(q1.DeQueue());
        }

        
        int topElement = q1.top();

        
        q2.Enqueue(q1.DeQueue());

    
        QueueLinkedlist temp = q1;
        q1 = q2;
        q2 = temp;

      //  System.out.println("Top element -> " + topElement);
        return topElement;
    }

    
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Stackusingtwoqueues stack = new Stackusingtwoqueues();

        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        
        System.out.println("Top element is: " + stack.top()); 
        stack.pop(); 
        stack.pop(); 
        stack.pop(); 
        stack.pop(); 

    
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}

