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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        
        // if (root.val == V) {
        //     res[0] = root;
        //     res[1] = root.right;
        //     root.right = null;
        // } 这样写【2，1，3】 2 就成了【【2， 1】，【】】
        //go left
        
        if (root.val > V) {
            TreeNode[] left = splitBST(root.left, V);
            res[0] = left[0];
            root.left = left[1];
            res[1] = root;
        } else {
            //go right
            TreeNode[] right = splitBST(root.right, V);
            res[1] = right[1];
            root.right = right[0];
            res[0] = root;
        }
        
        return res;
    }
}776. Split BST
