public class LL{
    Node head;
    private int size;
    LL(){
        this.size=0;
    }
    public class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    public void Addfirst(String data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void Addlast(String data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node curnode= head;
        while(curnode.next != null){
            curnode=curnode.next;

        }
        curnode.next=newnode;

        }
        public void printlist(){
            if(head==null){
                System.out.println("list is empty");
                return;
            }
            Node curnode= head;
        while(curnode != null){
            System.out.print(curnode.data+ " ->");
            curnode=curnode.next;

        }
        System.out.println("   Null");

    }

    public void Deletefirst(){
        if(head==null){
            System.out.println("the list is empty");
            return;
        
        }
        size--;
        head=head.next;
    }
    public void Deletelast(){
        if(head==null){
            System.out.println("the list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head= null;
            return;
        }
        Node n= head;
        Node s= head.next;
        while(s.next != null){
            s= s.next;
            n= n.next;
        }
        n.next = null;

    }
    public int getsize(){
        return size;
    }



    public static void main(String[] args) {
        LL list = new LL();
        list.Addfirst( "  a");
        list.Addfirst("  is");
        list.printlist();
        list.Addlast(" list");
        list.printlist();
        list.Addfirst(" this");
        list.printlist();
        list.Deletefirst();
        list.printlist();

        list.Deletelast();
    
    list.printlist();
    System.out.println(list.getsize());
    list.Addfirst( "  this");
    System.out.println(list.getsize());

    }

}