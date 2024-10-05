public class Task3 {

    public void sortfour(int arr[]){
        int a = arr[0], b = arr[1], c = arr[2], d = arr[3];

        if (a > b) { int temp = a; a = b; b = temp; }

        if (c > d) { int temp = c; c = d; d = temp; }

        if (a > c) { int temp = a; a = c; c = temp; }

        if (b > d) { int temp = b; b = d; d = temp; }

        if (b > c) { int temp = b; b = c; c = temp; }


        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
    }
    public static void main(String[] args) {
        Task3 sorter = new Task3();
        int[] arr = {38, 27, 43, 9};

        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        sorter.sortfour(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
    
}
