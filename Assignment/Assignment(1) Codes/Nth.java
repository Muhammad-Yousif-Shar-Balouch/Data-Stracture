
public class Nth{

class Linkedlist{
    class Node{


        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;

        }}
        Node head;

    public  void addfirst(int data){
            Node newnode = new Node(data);
            if(head==null){
                head=newnode;
            }
            else{
                newnode.next=head;
                head=newnode;
            }
        }



        public void addlast(int data){
            Node newnode = new Node(data);
            if(head==null){
                head=newnode;
            }
            else{
               Node temp= head;
               while(temp.next !=null){
                temp= temp.next;
               }
                temp.next=newnode;
               }
            }


            public int getnthnode(int index){
                int i=0;
                Node temp = head;
                while(temp != null){
                    if(i==index){
                        return temp.data;
                    }
                    i++;
                    temp = temp.next;
                }
                return -1;

            }
            public void printlist(){
                Node temp=head;
                if(head == null){
                    System.out.println("list is empty");
                }
                while(temp != null){
                    System.out.println(temp.data+" ");
                    temp=temp.next;
                }

            System.out.println();
            }
        }

 public static void main(String[] args) {
        Nth nth = new Nth();
        Linkedlist list= nth.new Linkedlist();

        list.addfirst(2);
        list.addlast(3);
        list.addlast(5);

        list.printlist(); // Output: 2 3 5

        System.out.println("Element at index 1: " + list.getnthnode(1)); // Output: 3
    }
}