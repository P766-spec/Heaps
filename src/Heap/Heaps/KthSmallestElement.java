package Heap.Heaps;

import java.util.PriorityQueue;

// find kth smallest and largest element in an array using heap with priority queue
public class KthSmallestElement {
    public static int find(int[] A, int k) {    // l = starting index of the array i.e 0 and r = ending index of the zero i.e size - 1
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < A.length; i++) {
            pq.offer(A[i]);     // offer basically pushes the element in the queue

        }
      int n  = -1;
        while(k > 0) {
            n = pq.poll();
            k--;
        }
        return n;
    }
    public static int KthLargestElement(int k, int[] arr) {
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }

        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
         // int[] A= {1, 2, 10, 20,  40, 32, 44, 51, 6};
        int[] arr = {1, 2, 10, 20,  40, 32, 44, 51, 6};
        int k  = 4;
        System.out.println("3rd largest element: " + KthLargestElement(3, arr));
    }
}
