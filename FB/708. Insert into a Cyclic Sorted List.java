/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        // if start is null, create a node pointing to itself and return
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        // is start is NOT null, try to insert it into correct position
        Node curr = head;
        //一直循环找合适的点，找到返回 
        while (true) {
            if (curr.val < curr.next.val) {
                // 在上升方向上找，x in between cur and next
                if (insertVal >= curr.val && insertVal <= curr.next.val) {
                    insertAfter(curr, insertVal);
                    break;
                } 
            } else if (curr.val > curr.next.val) {
                //在下降方向上， 且x不在max min之间，只能插在这
                if (insertVal >= curr.val || insertVal <= curr.next.val) {
                    insertAfter(curr, insertVal);
                    break;
                }
            } else {
                //两点相同，若不是起始点则继续走，是起始点说明所有点相同，随意插入即可
                if (curr.next == head) {
                    insertAfter(curr, insertVal);
                    break;
                }
            }
            
            curr = curr.next; 
        }

        return head;
    }
    
    // insert value x after Node cur
    private void insertAfter(Node cur, int x) {
        cur.next = new Node(x, cur.next);
    }
}
