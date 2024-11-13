
public class Task1 {

    public static void DecimaltoBinary(int n){
        if(n==0){
            return;
        }
        
            DecimaltoBinary(n/2);
            System.out.print(n%2);
        
    }
    public static void main(String[] args) {
        int n=13;
        System.out.println("the decimal no is---->"+n);
        System.out.println("the binary no is----> ");
        DecimaltoBinary(n);
    

    }
}
