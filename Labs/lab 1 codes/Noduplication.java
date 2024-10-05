public class Noduplication {
    public static void main(String[] args) {
        int arr2D[][]={
            {1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,}};
              int arr1D[]=new int[20];
              int a=NoDup(arr2D,arr1D);
               for(int i=0; i<a;i++){
                 System.out.println(arr1D[i]+ " ");
                }
             }
     public static int NoDup(int [][] arr2D , int [] arr1D){
         int index =0;
            for (int i=0; i<arr2D.length;i++){
            for(int j=0;j<arr2D[i].length;j++){
                int element =arr2D[i][j];
                boolean isDuplicate=false;
                 for (int k=0;k<index;k++){
                    if(arr1D[k]==element){
                     isDuplicate=true;
                       break;}}
                if(!isDuplicate){
                    arr1D[index++]=element;
                } }
        }
        return index;
    }}
    
    
