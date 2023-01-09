package Heap.Heaps;

import java.util.PriorityQueue;

// Merge k sorted lists : Leetcode
class ListNode {
    int val;
    ListNode next;
        ListNode(int val, ListNode next) {
            this.val  = val;
            this.next = next;
        }

    public ListNode() {

    }
}

class Solution{
public ListNode mergeKLists (ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
        return a.val - b.val;
    });
    ListNode head = new ListNode();
    ListNode temp = head;

    for(ListNode list : lists) {
        if(list != null)
            pq.add(list);
    }
    while( !pq.isEmpty()) {
        ListNode t = pq.poll();
        temp.next = t;
        if(t.next != null)
            pq.add(t.next);
        temp = temp.next;
    }
    return head.next;




    }
}
