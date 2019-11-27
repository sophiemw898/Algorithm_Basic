//iteration O(N) O(1)
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
        Node temp = root;
        
        //use temp as the pointer to travel level by level
        while (temp != null) {
            Node curr = temp;
            //travel current level;
            while (curr != null) {
                if (curr.left == null) {
                    break;
                }
                if (curr.left != null) {
                    curr.left.next = curr.right;
                } 
                if (curr.next != null) {
                    //System.out.println(curr.next.val);
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            temp = temp.left;
        }
        
        return root;
    }
}

//BFS O(N)O(N)
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

//recursion O(N)O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}

