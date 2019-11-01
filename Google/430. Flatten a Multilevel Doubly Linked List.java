/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        while(head != null) {
            
            if (head.child != null) {
                
                Node currNext = head.next;
                
                //process child
                head.next = flatten(head.child);
                head.next.prev = head;
                head.child = null;
                
                //move to tail
                while (head.next != null) {
                    head = head.next;
                }
                
                //connect tail;
                if (currNext != null) {
                    head.next = currNext;
                    currNext.prev = head;
                }
                
            }
            
            head = head.next;
        }
        
        return dummy.next;
    }
}
