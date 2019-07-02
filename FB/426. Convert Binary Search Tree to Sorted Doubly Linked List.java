/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //save start node
        Node start = root;
        while (start.left != null) {
            start = start.left;
        }
        
        Node cur = root;
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            //link
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            
            prev = cur;
            //if (cur.right != null) {
                //stack.push(cur.right);
                cur = cur.right;
            //}
        }
        start.left = prev;;
        prev.right = start;
        return start;
    }
}
