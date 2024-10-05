import java.util.Stack;

public class Task3 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
           public void addtoback(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        
        public void printReverseUsingStack() {
            Stack<Node> stack = new Stack<>();

            Node temp = head;

            
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }


            while (!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
            }
        }
    

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NuLLa");

    }

    public static void main(String[] args) {
        Task3 task = new Task3();
        

        task.addtoback(40);
        task.addtoback(30);
        task.addtoback(20);
        
        task.addtoback(10);
        System.out.println("orginal");
        task.print();


        System.out.print("Linked List in reverse order (using stack): ");
        task.printReverseUsingStack();  
    }
}

