public class Prat {
    public static int fab(int n){
        if(n<=2){
            System.out.print(n+" ");
            return n;
        }
        System.out.print((fab(n-1)+fab(n-2))+ " ");
        return fab(n-1)+fab(n-2);
    }
   
    public static void main(String[] args) {
    
        int n=4;
        
      fab(n);
    }
}
