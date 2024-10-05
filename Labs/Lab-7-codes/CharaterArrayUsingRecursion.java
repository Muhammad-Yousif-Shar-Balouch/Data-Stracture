public class CharaterArrayUsingRecursion {
    

    public static void forward(char[]arr, int index){
        if(index==arr.length){
            return;
        }
        System.out.print(arr[index]+" ");
        forward(arr, index+1);
    }

    public static void reverse(char[]arr, int index){

        if(index < 0){
            return;
        }
        System.out.print(arr[index]+" ");
        reverse(arr, index-1);

    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("Array in forward direction:");

        forward(arr, 0);
        System.out.println();
        System.out.println("Array in reverse direction:");

        reverse(arr, arr.length-1);
    }
}
