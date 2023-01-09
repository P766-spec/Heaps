package Heap.Heaps;
// check if an array represents a min-heap or not : Recursive solution
public class CheckMinHeap {
    public static boolean checkMinHeap(int[] A, int i) {
        if(2*i + 2 > A.length) {   // if i is a leaf node
            return true;
        }
        // if i is a internal node recursively check if the left child is a heap
        boolean left = (A[i] <= A[2*i + 1]) && checkMinHeap(A, 2*i + 1 );
        // Similarly check  for right child

        boolean right = (2* i + 2 == A.length) || (A[i] <= A[2*i + 2] && checkMinHeap(A,2 * i + 2));

        return left && right;
    }
    // Iterative solution
    public static boolean check(int[] A) {
        if(A.length <= 1) {
            return true;
        }
        for (int i = 0; i <(A.length - 2)/2 ; i++) {
            if (A[i] > A[2 * i + 1] || (2 * i + 2) != A.length && A[i] > A[2 * i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        int index = 0;

        if(checkMinHeap(A,index)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }
    }
}
