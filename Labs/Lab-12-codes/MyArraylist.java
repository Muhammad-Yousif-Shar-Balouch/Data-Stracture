public class MyArraylist<T> {
    private T[] asArray; // Underlying array to store elements
    private int size;    // Current number of elements in the list

    @SuppressWarnings("unchecked")
    public MyArraylist() {
        asArray = (T[]) new Object[10]; // Initial capacity of 10
        size = 0;
    }

    // Appends the element to the end of the list
    public void add(T value) {
        ensureCapacity();
        asArray[size++] = value;
    }

    // Inserts the new element at the specified index
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ensureCapacity();
        // Shift elements to the right to make space
        for (int i = size; i > index; i--) {
            asArray[i] = asArray[i - 1];
        }
        asArray[index] = value;
        size++;
    }

    // Removes the element at the specified index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            asArray[i] = asArray[i + 1];
        }
        asArray[size - 1] = null; // Clear last element
        size--;
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Checks if the list has any elements
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if the list contains a specified value
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (asArray[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Replaces the element at the specified index with a new value
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        asArray[index] = value;
    }

    // Returns the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return asArray[index];
    }

    // Ensures that the array has enough capacity to add more elements
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == asArray.length) {
            int newCapacity = asArray.length * 2;
            T[] newArray = (T[]) new Object[newCapacity];
            for (int i = 0; i < asArray.length; i++) {
                newArray[i] = asArray[i];
            }
            asArray = newArray;
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        MyArraylist<Integer> myList = new MyArraylist<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("Size: " + myList.size()); // Size: 3
        System.out.println("Element at index 1: " + myList.get(1)); // 2

        myList.insert(1, 5);
        System.out.println("After insert at index 1: " + myList.get(1)); // 5

        myList.delete(2);
        System.out.println("After delete at index 2: " + myList.get(2)); // 3

        System.out.println("Contains 3? " + myList.contains(3)); // true
        myList.set(0, 10);
        System.out.println("After set at index 0: " + myList.get(0)); // 10
        System.out.println("Is empty? " + myList.isEmpty()); // false
    }
}
