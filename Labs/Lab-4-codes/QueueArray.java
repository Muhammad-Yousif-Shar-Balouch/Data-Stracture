
public class QueueArray {
    private int arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

QueueArray(int size){
    arr=new int[size];
     front=0;
     rear=-1;
     capacity= size;
     count=0;

}
public void enqueue(int x){
    if(isFull()){
        System.out.println("Queue is over flow");
        return;
    }
    
        rear=  ( rear+1)% capacity;
        arr[rear]=x;
        count++;
        System.out.println("Inserting---->"+x);
    

}
public void dequeue(){
    if(isEmpty()){
        System.out.println("Queue is underflow");
        return;
    }
    System.out.println("Removing---->"+arr[front]);
    front=(front+1)  %  capacity;
    count--;


}
public int peek(){
    if (isEmpty()) {
        System.out.println("Queue is empty! No front element.");
        return -1;
    }
    return arr[front];
}
public Boolean isEmpty() {
    return count == 0;
}
public Boolean isFull() {
    return count == capacity;
}
public int size() {
    return count;
}

public static void main(String[] args) {
     QueueArray q = new QueueArray(5); 
 
        q.enqueue(1); 
        q.enqueue(2); 
        q.enqueue(3); 
 
        System.out.println("Front element is: " + q.peek()); 
        q.dequeue(); 
        System.out.println("Front element is: " + q.peek()); 
 
        System.out.println("Queue size is " + q.size()); 
 
        q.dequeue(); 
        q.dequeue(); 
 
        if (q.isEmpty()) 
            System.out.println("Queue Is Empty"); 
        else 
            System.out.println("Queue Is Not Empty"); 
    } 
}  











