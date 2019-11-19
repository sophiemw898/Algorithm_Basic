//O(N) O(N)
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
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return res;
        }
        
        helper(root, root.val, 1);
        return res;
    }
    
    private void helper(TreeNode node, int parent, int length) {
        if (node == null) {
            return;
        }
        
        int currLength = 1;
        if (node.val == parent + 1) {
            currLength = length + 1;
        }
        res = Math.max(res, currLength);
        
        helper(node.left, node.val, currLength);
        helper(node.right, node.val, currLength);
    }
}
