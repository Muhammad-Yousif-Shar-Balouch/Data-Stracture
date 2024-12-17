import java.util.ArrayList;
import java.util.List;

public class PriorityQueueSorted {
    private List<Integer> array;

    public PriorityQueueSorted() {
        array = new ArrayList<>();
    }

    public void insert(int data) {
        try {
            int i = 0;
            while (i < array.size() && array.get(i) < data) {
                i++;
            }
            array.add(i, data);
        } catch (Exception e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }
    public int extractMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return array.remove(array.size() - 1);
    }

    public int getMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return array.get(array.size() - 1);
    }


    public boolean searchData(int data) {
        try {
            return array.contains(data);
        } catch (Exception e) {
            System.out.println("Error while searching data: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        PriorityQueueSorted pq = new PriorityQueueSorted();

        pq.insert(10);
        pq.insert(30);
        pq.insert(20);
        pq.insert(50);
        pq.insert(40);

        System.out.println("Maximum Value: " + pq.getMax());

        System.out.println("Is 10 present? " + pq.searchData(10));
        System.out.println("Is 80 present? " + pq.searchData(80));

        System.out.println("Extracted Max: " + pq.extractMax());

        System.out.println("New Maximum Value: " + pq.getMax());
    }
}

