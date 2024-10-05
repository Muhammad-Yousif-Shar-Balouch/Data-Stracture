
public class QueueLinkedlist {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next= null;
        }
    }
    private  Node rear=null,    front=null;
    int size=0;

    public void Enqueue(int data){
        Node newnode= new Node(data);
        if(rear==null){
            front=rear=newnode;
        }

        else{
            rear.next=newnode;
            rear=newnode;
            
            
        }
     //   System.out.println("Enqueued ->"+data);
        size++;
        }
        public int DeQueue(){
            if(front==null){
                System.out.println("list is empty");
                return-1;
            }
            else{
                int k=front.data;
                front=front.next;
                if(front==null){
                rear=null;
                }

                
               // System.out.println("DeQueued ->"+k);
                size--;
                return k;


            }
        }
        public int top(){
            if(front!=null){
                return front.data;
            }
        else{
            System.out.println("Queue is Empty");
            return-1;
        }
        }
        public boolean isEmpty(){
         return   front==null;
            
        }
        public static void main(String[] args) {
             QueueLinkedlist q = new QueueLinkedlist(); 
        q.Enqueue(1); 
        q.Enqueue(2); 
        q.Enqueue(3); 
        q.Enqueue(4); 
    

     
        
 
        System.out.printf("Front element is %d\n", q.top()); 
 
        q.DeQueue(); 
        q.DeQueue(); 
        q.DeQueue(); 
        q.DeQueue(); 
    System.out.println("size of Queue  --->"+q.size);
        
        
 
        if (q.isEmpty()) { 
            System.out.print("Queue is empty"); 
        } else { 
            System.out.print("Queue is not empty"); 




        }
        }
    }






    

    

