public class StackArray {
    int arr[]= new int[5];
    int top=-1;
    public void push(int x){
        if(top < arr.length-1){
            arr[++top]=x;
        }
        else{
            System.out.println("Stack is full");
        }}

        public int pop(){
            if(top > -1){
                return arr[top--];
            }
            else{
                System.out.println("stack is empty");
                return -1;
            }
        
    }
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return arr[top];
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        StackArray S= new StackArray();
       // S.push(2);
    //    S.push(4);
    //    S.push(7);
        
       // System.out.println("Top element: " + S.peek());

    
       // System.out.println("Popped: " + S.pop());
      //  System.out.println("Popped: " + S.pop());

    
        System.out.println("Is stack empty? " + S.isEmpty());
    }
    
}
