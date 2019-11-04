import java.util.Arrays;

public class BinaryHeap {

    public int[] heap;
    public int size;

    public BinaryHeap(){
        heap = new int[10];
        size = 0;
    }

    //add item to heap, grow heap if needed
    public void add(int value){

        if(size == heap.length){
            heap = Arrays.copyOf(heap, heap.length*2);
        }

        heap[size++] = value;
        int current = size-1;
        int parent = (current-1)/2;
        while(current != 0 && heap[current] < heap[parent]){
            swap(heap, current, parent);
            current = parent;
            parent = (parent-1)/2;
        }

    }

    void swap(int [] a, int i, int j){

        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //remove item from heap, call shiftdown function
    public int remove() {

        try{

            if (size == 0){
                throw new Exception();
            }

        }
        catch (Exception e){
            System.out.println("error");
        }

        swap(heap, 0, size-1);
        size--;
        if(size > 0){
            siftDown(0);
        }
        return heap[size];


    }

    //helper function for remove()
    private void siftDown(int value){

        int parent = value;
        int l = 2*parent+1;
        int r = 2*parent+2;


        if (l >= size || r >= size) {
            return;
        }

        //find smallest child
        if (heap[l] > heap[r] && heap[r] < heap[parent]) {
            swap(heap, parent, r);
            siftDown(r);
        }
        else if(heap[r] > heap[l] && heap[l] < heap[parent]) {
            swap(heap, parent, l);
            siftDown(l);
        }

    }

}
