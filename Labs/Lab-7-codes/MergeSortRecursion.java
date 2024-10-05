public class MergeSortRecursion {

    public static void print(int arr[])
    {
        for(int i=0; i< arr.length;i++)
        {
            System.out.println(arr[i]+" --->");
        }
        System.out.println();
    }

    public static  void mergesort(int arr[], int start,int end)
    {
        if(start>=end){
            return;
        }
        int mid= start+(end-start)/2;
        mergesort(arr, start, mid);
        mergesort(arr,  mid+1, end);
        merge(arr, start,mid, end);
    }
    public static void merge(int arr[], int start, int mid, int end )
    {
        int temp[]= new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<= end)
        {
            if(arr[i]< arr[j]){
                 temp[k]=arr[i];
                i++; 
            }
            else{
                 temp[k]= arr[j];
                j++; 
            }
            k++;
        }
        while(i<=mid)
        {
            temp[k++]= arr[i++];
        }
        while(j<=end)
        {
            temp[k++]= arr[j++];
        }
    
    for(k=0, i=start;  k < temp.length; k++, i++){
    
        arr[i]= temp[k];

    }}
   

    public static void main(String[] args) {
        int arr[]={5,4,3,2,1,-5,-7,45};
        mergesort(arr, 0, arr.length-1);
        print(arr);
        

    }
    
}
