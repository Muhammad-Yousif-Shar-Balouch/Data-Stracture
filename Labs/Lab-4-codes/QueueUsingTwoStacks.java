public class QueueUsingTwoStacks extends StackLinkedlist{
    
    StackLinkedlist s1= new StackLinkedlist();
    StackLinkedlist s2= new StackLinkedlist();


    // public boolean isempty(){
    //     s1.head==null;  && s2.head==null;
    // }
    public void enqueue(int data){
        s1.push(data);
    }
    public int dequeue(){
        while(!s1.isempty()){
            s2.push(s1.pop());
           


        }
        int k=s2.pop();

        while(!s2.isempty()){
            s1.push(s2.pop());
           

        }
        return k;
    }
    public static void main(String[] args) {
        QueueUsingTwoStacks q= new QueueUsingTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());       
         System.out.println(q.dequeue());




    }

     
}
