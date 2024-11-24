import java.util.ArrayList;
import java.util.List;
public class PriorityQueue{
    private List <Integer> array;

    public PriorityQueue(){
        array= new ArrayList<>();


    }
    public void insert(int data){
        try{
            array.add(data);
        }catch(Exception e){
            System.out.println("Error while inserting data"+e.getMessage());
        }

    }

    public  int extractMax(){
        if(array.isEmpty()){
            throw new IllegalStateException("Priority Queue is empty");
        }
        int Maxindex=0;
        for(int i=1;i<array.size();i++){
            if(array.get(i)>array.get(Maxindex)){
                Maxindex=i;
            }
        }
        int Maxvalue=array.get(Maxindex);
        array.remove(Maxindex);
        return Maxvalue;

    }
    public  int getMax(){
        if(array.isEmpty()){
            throw new IllegalStateException("Priority Queue is empty");
        }
        int Maxvalue=array.get(0);
        for(int value:array){
            if(value> Maxvalue){
                Maxvalue=value;
            }
        }
        return Maxvalue;

    }
    public  boolean searchData(int data){
        try{
            return array.contains(data);
        }catch (Exception e) {
            System.out.println("Error while inserting data: " + e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        PriorityQueue pq= new PriorityQueue();
        pq.insert(10);
        pq.insert(30);
        pq.insert(20);
        pq.insert(50);
        pq.insert(40);


        System.out.println("Maximum Value: " + pq.getMax()); // Output: 50

        // Test searchData
        System.out.println("Is 30 present? " + pq.searchData(30)); // Output: true
        System.out.println("Is 100 present? " + pq.searchData(100)); // Output: false

        // Test extractMax
        System.out.println("Extracted Max: " + pq.extractMax()); // Output: 50
        System.out.println("New Maximum Value: " + pq.getMax());

    }
}