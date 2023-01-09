package Heap.Heaps;
// Merge two Binary Max Heaps
public class MergeBinary {
    public static void maxHeapify(int[] arr, int n, int i) {
        if(i >= n) {
            return;
        }
        int l =  2 * i + 1;
        int r = 2 * i + 2;
        int max;
        if(l < n && arr[l] > arr[i]) {
            max = l;
        }
        else
            max = i;
        if (r < n && arr[r] > arr[max]) {
            max = r;
        }
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            maxHeapify(arr,n,max);
        }
    }
    public static void mergeHeaps(int[] arr, int[] a, int[]b, int n, int m) {
        for (int i = 0; i < n ; i++) {
            arr[i] = a[i];
        }
        for (int i = 0; i < m ; i++) {
            arr[n + i] = b[i];
        }
        n = n + m;

        for (int i = n / 2 - 1; i >= 0 ; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        int n = a.length;
        int m = b.length;

        int[] merged = new int[m + n];
        mergeHeaps(merged,a,b,n,m);

        for (int i = 0; i < m + n; i++) {
            System.out.println(merged[i] + " ");
            System.out.println();

        }
    }
}
