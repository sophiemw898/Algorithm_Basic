/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        //find middle 1-2-3-4-5-6
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the secont half 1>2>3 6>5>4// 1>2>3 5>4
        ListNode tail = reverse(slow.next);
        slow.next = null;
        
        //merge two half list one by one
        while (head != null && tail != null) {
            ListNode next1 = head.next;
            ListNode next2 = tail.next;
            
            tail.next = next1;
            head.next = tail;
            
            head = next1;
            tail = next2;
        }
        
        return;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
