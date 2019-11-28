//O(n) O(N) use space trade off time T(n) = 2T(n/2) + O(1)------O(N)
class Solution {
    
    List<Integer> values = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        mapListToArray(head);
        
        return convert(0, values.size() - 1);
    }
    
    private void mapListToArray(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
    }
    
    private TreeNode convert(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(values.get(start));
        }
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        
        root.left = convert(start, mid - 1);
        root.right = convert(mid + 1, end);
        return root;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//T(n) = 2T(n/2) + O(n)------O(NLogN)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        //find the middle, divide the listNode into two half
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //1 -2 -3 -4 slow 2 fast 
        ListNode right = slow.next;
        TreeNode root = new TreeNode(slow.val);
        ListNode left = null;
        if (prev != null) {
            prev.next = null;
            left = head;
        }
        
        //recursion
        TreeNode leftNode = sortedListToBST(left);
        TreeNode rightNode = sortedListToBST(right);
        
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
}
