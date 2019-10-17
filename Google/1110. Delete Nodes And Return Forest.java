//O(n) O(n)
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
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        
        helper(root, true);
        return res;
    }
    
    private TreeNode helper(TreeNode node, boolean isRoot) {
        if (node == null) {
            return null;
        }
        
        boolean isDeleted = set.contains(node.val);
        
        if (isRoot && !isDeleted) {
            res.add(node);
        }
        //update children
        node.left = helper(node.left, isDeleted);
        node.right = helper(node.right, isDeleted);
            
        return isDeleted ? null : node;
    }
}
