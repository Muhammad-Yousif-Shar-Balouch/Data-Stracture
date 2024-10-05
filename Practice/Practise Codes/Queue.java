public class Queue {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head, tail;
    int size=0;
    public void enqueue(int data){
        Node newnode = new Node(data);
        if(head==null){
            head=newnode;
            tail= newnode;

        }
        else{
            tail.next=head;
            tail= newnode;

        }
        size++;
    }
    public int dequeue(){
        if(head== null){
            return -1;

        }
        else{
            int k = head.data;
            head=head.next;
            size--;
            return k;

        
            

        }
    

    }
    public static void main(String[] args) {
        Queue q= new Queue();
        q.enqueue(2);
        System.out.println(q.dequeue());
        q.enqueue(3);
        q.enqueue(35);
        q.enqueue(38);
        System.out.println(q.dequeue());
        q.enqueue(30);
        q.dequeue();
        System.out.println(q.size);









    }


    
}
