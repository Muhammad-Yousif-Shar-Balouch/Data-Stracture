public class Task5 {
    Node head;
    class Node{

        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  boolean iscycle(){
        Node slow= head;
        Node fast= head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
return false;
    }
    public static void main(String[] args) {
    Task5 t = new Task5();
      t.  head= t.new Node(1);
       t. head.next= t.new Node(2);
       t. head.next.next= t.new Node(3);
       t. head.next.next.next= t.head;
        System.out.println(t.iscycle());
    }

}
