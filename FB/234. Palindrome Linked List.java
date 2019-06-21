/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //find the mid node 
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }//odd numbers, 2nd half is longer
        
        if (fast != null) {
            slow = slow.next;//odd numbers, 2nd half is shorter
        }
        //reverse the 2nd half slow, 1st half is fast
        slow = reverse(slow);
        fast = head;
        
        //compare two halves
        //fast 1st half没断开，结束看slow. 奇数slow多一个 无需比较最后一个值，及中间值
        while (slow != null ) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
