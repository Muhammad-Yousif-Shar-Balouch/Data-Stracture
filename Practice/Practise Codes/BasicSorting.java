public class BasicSorting {
    public static  boolean BubbleSort(int arr[]){
        for(int i=0;i  <  arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                return false;
            }


        //   //  int swaps=0;
        //     for(int j=0;j <  arr.length-1-i;j++){
        //         if(arr[j]  >  arr[j+1]){
        //             int temp = arr[j];
        //             arr[j] =  arr[j+1];
        //             arr[j+1] =  temp;
        //            // swaps++;
        //         }
        //     }
        }
        return true;
    }
    public static void printArr(int arr[]){
        for(int i=0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
      //  System.out.println();
    }

    public static void SelectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){

               // For Assending order
                if(arr[minPos ]> arr[j]){

                    //For Dessending order
                  //  if(arr[minPos ]< arr[j])
                   minPos=j;
                }
            }
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;

        }
    }
    public static void insertionSort(int arr[]){
        for(int i=0;i < arr.length;i++){
            int curr=arr[i];
            int prev=i-1;

            while(prev>=0 && arr[prev] > curr){
                arr[prev+1]= arr[prev];
                prev--;

            }
            arr[prev+1] = curr;
         }
    }



    public static void main(String[] args) {
      // int arr[]={5,3,1,2,4};

       int arr[]={1,2,3,4,5};
       BubbleSort( arr);
    //    printArr(arr);
      // SelectionSort(arr);

   // insertionSort(arr);


       printArr(arr);
    }
    
}
