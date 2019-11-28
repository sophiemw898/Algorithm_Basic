//O(n) O(1) iteration
class Solution {
    public Node connect(Node root) {
        
        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level
        
        while (cur != null) {
            
            while (cur != null) {
                //current level
                //in each level, we need to find the head and update the next pointer
                
                //update left child first
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                
                //move to next point
                cur = cur.next;
            }
            
            //go to next level
            cur = head;
            head = null;
            prev = null;
        }
        
        return root;
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            prev = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = prev;
                prev = node;

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return root;
    }
}
