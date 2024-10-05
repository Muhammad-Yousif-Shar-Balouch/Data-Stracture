public class T2 {
    Node head;
    Node tail;
   // int size;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }}
    public void Addfirst(int data){
        Node newnode= new Node( data);
        if(head==null){
            head=newnode;
            tail= newnode;
          //  size++;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

public void Addlast(int data){
    Node newnode= new Node( data);
    if(head==null){
        head=newnode;
        tail=newnode;
      //  size++;
        return;
    }
    tail.next=newnode;
    tail=newnode;
}
public void Removefirst(){
    if(head==null){
        System.out.println("list is empty");
    }
    if(head==tail){
        head=tail=null;
      //  size--;
        return;
    }
    head=head.next;
}
public void Removelast(){
    if(head==null){
        System.out.println("list is empty");
        return;
    }
    if(head==tail){
        head=tail=null;
       // size--;
        return;
    }
    Node temp=head;
    while(temp.next.next!=null){
        temp= temp.next;}
        tail=temp;
        temp.next=null;
    
    
}
public void Print(){
    Node temp=head;
    if(head==null){
       // Node temp=head;
        System.out.println("list is empty");
        return;
    }
    while (temp!=null){
        System.out.println(temp.data+" ->");
        temp= temp.next;

    }
    System.out.println(" Null");

}
public static void main(String[] args) {
    T2 t = new T2();
t.Addfirst(2);
t.Print();
t.Addfirst(3);
t.Print();
t.Addfirst(1);
t.Print();
    t.Addlast(4);
    t.Print();
    t.Addlast(5);
    t.Print();
    t.Addlast(6);
    t.Print();
    t.Removefirst();
    t.Print();
    t.Removelast();
    t.Print();
}
}
