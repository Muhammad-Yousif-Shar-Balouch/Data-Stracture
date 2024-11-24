import java.util.ArrayList;

public class PriorityQueueHeap {
    private ArrayList<Integer> heap;


    public PriorityQueueHeap() {
        heap = new ArrayList<>();
    }


    public void insert(int data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }


    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);


        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return max;
    }

    public int getMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }


    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, largest, size = heap.size();

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largest = index;

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest == index) {
                break;
            }


            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


    public boolean searchData(int data) {
        return heap.contains(data);
    }

    public static void main(String[] args) {
        PriorityQueueHeap pq = new PriorityQueueHeap();
        pq.insert(10);
        pq.insert(30);
        pq.insert(20);
        pq.insert(50);
        pq.insert(40);

        System.out.println("Maximum Value: " + pq.getMax());

        System.out.println("Is 30 present? " + pq.searchData(30));
        System.out.println("Is 100 present? " + pq.searchData(100));

        System.out.println("Extracted Max: " + pq.extractMax()); 

        System.out.println("New Maximum Value: " + pq.getMax());
    }
}

