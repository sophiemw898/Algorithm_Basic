//Time Complexity: O(min(N_1, N_2)), where N_1, N_2are the lengths of root1 and root2.
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || 
            (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
