import java.util.Stack;

public class Task1{
     
    public boolean BalancedBrackets(String str){

        Stack <Character> c= new Stack<>();
        for(int i=0; i< str.length(); i++){
            char ch= str.charAt(i);

            if(ch=='('|| ch=='{' || ch=='['){
                c.push(ch);
            }
            else{
                if( c.isEmpty()){
                    return false;
                }
                if(c.peek()== '(' && ch== ')'|| c.peek()== '{' && ch== '}' || c.peek()== '[' && ch== ']'){
                    c.pop();
                }
                else{
                    return false;
                }
               
            }
        }
        if(c.isEmpty()){
            return true;
        }
        else {
            return false;
        }


    }
    public static void main(String[] args) {
        Task1 t= new Task1();
      boolean result=  t.BalancedBrackets("{()}[");
       // t.BalancedBrackets("(");
        //t.BalancedBrackets("[");

      System.out.println(result);

    //  System.out.println(result);


       // System.out.println(result);


        
        
    }
}