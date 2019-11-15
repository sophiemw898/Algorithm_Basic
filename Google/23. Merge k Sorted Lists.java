//Divide and conquer O(NlogK)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeK(lists, 0, lists.length - 1);        
    }
    
    private ListNode mergeK(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeK(lists, start, mid);
        ListNode right = mergeK(lists, mid + 1, end);
        
        return merge(right, left);
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        
        node.next = a != null ? a : b;
        
        return dummy.next;
    }
}


//O(NlogK) PriorityQueue
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        //pop minimum
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        //initialazion: pup head.val in pq
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            
            head = head.next;
        }
        
        return dummy.next;
    }
}
