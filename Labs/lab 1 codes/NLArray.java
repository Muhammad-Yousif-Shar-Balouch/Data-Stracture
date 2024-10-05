public class NLArray {
    public static void main(String[] args) {
        int array[][]={{1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15},
         {16,17,18,19,20},{21,22,23,24,25}};
        //cropCenterPart(array);
        extractBoundries(array);
    }

}

public static void extractBoundries(int [][]arr){
    System.out.println(".....Boundries.....");
    int rows = arr.length;
    int cols = arr[0].length;

    for(int j=0;j<cols;j++){
        System.out.println(arr[0][j]+" ");

    }
    System.out.println( );
    for(int i=1;i<rows-1;i++){
        System.out.println(arr[i][0]+" ");
        System.out.println(arr[i][cols-1]);
        System.out.println();
    }
    for(int j=0;j<cols;j++){
        System.out.println(arr[rows-1][j]+" ");
    }
    System.out.println();
}