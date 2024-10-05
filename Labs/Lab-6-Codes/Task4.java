import java.util.Arrays;

public class Task4 {

    public  boolean TwoSum(int[] arr,int k){
        Arrays.sort(arr);

        int left=0;
        int right=arr.length-1;

        while(left <= right){
            int sum= arr[left]+arr[right];

            if(sum == k){
                return true;
            }
            else if(sum <k){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Task4 ts = new Task4();

    int[ ] arr= {8,7,1,6};

    int k=10;
    boolean result = ts.TwoSum(arr, k);
    System.out.println(result ? "Yes" : "No");
    }
    
}
