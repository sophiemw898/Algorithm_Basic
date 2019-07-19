/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//1.divide and conquer O(nklogk)
//T(n) = 2T(n/2) + O(nk)

//2.minHeap
//3.two by two non recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//1.divide and conquer O(nklogk)
//T(n) = 2T(n/2) + O(nk)

//2.minHeap
//3.two by two non recursion
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            public int compare (ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            head.next = node;
            head = head.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}

//lintcode
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        //return mergeLists_Divide_Conquer(lists, 0, lists.size() - 1);
        //return mergeLists_minHeap(lists);
        return mergeLists_non_recursion(lists);
    }
    
    private ListNode mergeLists_Divide_Conquer(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start)/2;
        ListNode right = mergeLists_Divide_Conquer(lists, mid + 1, end);
        ListNode left = mergeLists_Divide_Conquer(lists, start, mid);
        
        return merge2Lists(right, left);
    }
    
    private ListNode mergeLists_minHeap(List<ListNode> lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue(lists.size(), new Comparator<ListNode>() {
            public int compare (ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            head.next = node;
            head = head.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    private ListNode mergeLists_non_recursion(List<ListNode> lists) {
        while(lists.size() > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < lists.size() - 1; i += 2) {
                ListNode node = merge2Lists(lists.get(i), lists.get(i + 1));
                temp.add(node);
            }
            if (lists.size() % 2 == 1) {
                temp.add(lists.get(lists.size() - 1));
            }
            lists = temp;
        }
        
        return lists.get(0);
    }
    
    private ListNode merge2Lists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        
        if (node1 != null) {
            head.next = node1;
        }
        if (node2 != null) {
            head.next = node2;
        }
        
        return dummy.next;
    }
}
