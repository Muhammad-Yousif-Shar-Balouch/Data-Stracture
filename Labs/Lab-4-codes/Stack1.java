

public class Stack1{
    private int arr[];
    private int top;
    private int capacity;
    Stack1(int size){
        arr= new int[size];
        capacity=size;
        top= -1;
    }
    public void push(int x){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        arr[++top]=x;
        System.out.println("pushed ->"+x);

    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
    
        System.out.println("popped->"+arr[top]);
        return arr[top--];
    }
    public int top(){
        if (!isEmpty()) {
            return arr[top];
        }
        else{
            System.out.println("Stack is empty");
            return -1;
        }
    }
    public int size() {
        return top + 1;
    }
    public Boolean isEmpty() {
        return top == -1;
    }
    public Boolean isFull(){
        return top== capacity-1;
    }
    public static void main(String[] args) {
        Stack1 s= new Stack1(3);
        
 
        s.push(1);
        s.push(2);
 
        s.pop();
        s.pop();
 
        s.push(3);
 
        System.out.println("Top element is: " + s.top());
        System.out.println("Stack size is " + s.size());
 
        s.pop();
 
        if (s.isEmpty())
            System.out.println("Stack Is Empty");
        else{
            System.out.println("Stack Is Not Empty");
    }}
}