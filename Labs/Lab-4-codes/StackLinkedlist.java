public class StackLinkedlist {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next= null;

        }
    }
    private Node head;
    
   StackLinkedlist(){
    this.head= null;
   }
   public void push(int data){
    Node newnode = new Node(data);
//    if(isempty()){
//        head= newnode;
//        return;
//    }

    newnode.next=head;
    head= newnode;
   }
   public int pop(){
    if(isempty()){
        System.out.println("Stack is empty, cannot pop");
        return -1;
    }
    int top=head.data;
    head=head.next;
    return top;

   }
   public boolean isempty(){
    return head == null;
   }
   public int top() {
    if (!isempty()) {
        return head.data;
    } else {
        System.out.println("Stack is empty");
        return -1;
    }
}
   public static void main(String[] args)
   {
       StackLinkedlist stack = new StackLinkedlist();

       stack.push(1);
       stack.push(2);
       stack.push(3);

       System.out.println("Top element is " +  stack.top());

       stack.pop();
       stack.pop();
       stack.pop();

       if (stack.isempty()) {
           System.out.print("Stack is empty");
       } else {
           System.out.print("Stack is not empty");
       }
}
}