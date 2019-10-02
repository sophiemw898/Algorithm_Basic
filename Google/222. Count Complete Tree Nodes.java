//binary search
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        //calculate the depth of tree d
        //for first (d - 1) level, there are Math.pow(2, d) - 1 nodes when d > 1
        int d = computeDepth(root);
        if (d == 0) {
            return 1;
        }
    
        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 0;
        int right = (int)Math.pow(2, d) - 1;
        int res= 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (exists(mid, d, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int)Math.pow(2, d) - 1 + left;
    }
    
    //O(d) time
    private int computeDepth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
    
    private boolean exists(int index, int d, TreeNode node) {
        int left = 0; 
        int right = (int)Math.pow(2, d) - 1;
        int mid;
        for (int i = 0; i < d; i++) {
            mid = left + (right - left)/2;
            if (index <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        
        return node != null;
    }
}

//O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        
        return left + right + 1;
    }
}
