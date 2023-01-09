package Heap.Heaps;
// Min Heap implementation without libraries
public class Min_Heap {
    private int[] HeapArray;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public Min_Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        HeapArray = new int[this.maxSize + 1];
        HeapArray[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int  rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if(pos >= size/2 && pos <= size) {
            return true;
        }
        return false;
    }
    private void swap(int fpos, int spos) {
        int temp;
        temp = HeapArray[fpos];
        HeapArray[fpos] = HeapArray[spos];
        HeapArray[spos] = temp;
    }
    private void minHeapify(int pos) {
        if(isLeaf(pos)) {
            if(HeapArray[pos] > HeapArray[leftChild(pos)] || HeapArray[pos] > HeapArray[rightChild(pos)]) {
                if(HeapArray[leftChild(pos)] < HeapArray[rightChild(pos)])  {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(int element) {
        if(size >= maxSize) {
            return;
        }
        HeapArray[++size] = element;
        int current = size;

        while(HeapArray[current] < HeapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void display() {
        System.out.println("Parent Node " + "\t" + "Left Node " + "\t" + "Right Node");
        for (int i = 1; i <= size / 2 ; i++) {
            System.out.println(" " + HeapArray[i] + "\t\t" + HeapArray[2 * i] + "\t\t"  + HeapArray[2 * i + 1]);

            System.out.println();
        }
    }
    public void minHeap() {
        for(int pos  = (size / 2); pos >=1; pos--) {
            minHeapify(pos);
        }
    }
    public int remove() {
        int popped = HeapArray[FRONT];
        HeapArray[FRONT] = HeapArray[size--];
        minHeapify(FRONT);
        return popped;
    }
}

class Main1 {
    public static void main(String[] args) {
        System.out.println("The Min Heap is: ");
        Min_Heap minHeap = new Min_Heap(7);
        minHeap.insert(12);
        minHeap.insert(15);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(90);
        minHeap.insert(45);

        minHeap.minHeap();
        minHeap.display();
        System.out.println("The Min val(root node): " + minHeap.remove());

    }
}
