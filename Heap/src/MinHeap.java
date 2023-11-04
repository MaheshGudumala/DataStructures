//A class for min heap
public class MinHeap {

    private int[] heapArray;    //To store array of elements in heap

    private int capacity;   //max size of heap

    private int current_heap_size;   //current number of elements in heap

    //constructor
    public MinHeap(int n){
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    //swapping using reference
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //get parent index for the given index
    private int parent(int key){
        return (key - 1)/2;
    }

    //get the left child for the given index
    private int left(int key){
        return 2 * key + 1;
    }

    //get the right child index for the given index
    private int right(int key){
        return 2 * key + 2;
    }

    //insert new key
    public boolean insert(int key){
        if(current_heap_size == capacity) return false; //heap is full

        //first insert the new key at the end
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        return heapifyUp();
    }

    //bubbles up non-heap satisfying elements
    private boolean heapifyUp() {

        int i = current_heap_size-1;    //last element
        while(i != 0 && heapArray[i] < heapArray[parent(i)]){
            swap(heapArray, i, parent(i));
            i = parent(i);
        }

        return true;
    }

    //extract min
    private int getMin(){
        return heapArray[0];
    }

    //remove Min
    private int removeMin(){
        if(current_heap_size == 0) return Integer.MAX_VALUE;

        if(current_heap_size == 1){
            current_heap_size--;
            return heapArray[0];
        }

        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        heapifyDown();
        return root;
    }

    private void heapifyDown() {
        int index = 0;
        while(left(index) < current_heap_size){
            int smallerChild = left(index);
            if(right(index) < current_heap_size && right(index) < left(index)){
                smallerChild = right(index);
            }
            if(heapArray[index] < heapArray[smallerChild]) break;
            else{
                swap(heapArray, index, smallerChild);
                index = smallerChild;
            }
        }
    }
    public static void main(String args[]){
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        System.out.println(h.removeMin());
        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        System.out.println(h.removeMin() + " ");
        System.out.println(h.getMin() + " ");
    }

}
