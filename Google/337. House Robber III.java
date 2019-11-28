
public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);
    int[] res = new int[2];

    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    res[1] = root.val + left[0] + right[0];
    
    return res;
}

//use the map to save the node and result. much faster
class Solution {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }
    
    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        //did not choose root
        int noRoot = helper(root.left, map) + helper(root.right, map);
        
        //choose root
        int withRoot = root.val;
        withRoot += (root.left == null) ? 
                        0 : helper(root.left.left, map) + helper(root.left.right, map);
        withRoot += (root.right == null) ? 
                        0 : helper(root.right.left, map) + helper(root.right.right, map);
        
        int val = Math.max(withRoot, noRoot);
        
        map.put(root, val);
        
        return val;
    }
}

//super slow
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

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        //did not choose root
        int noRoot = rob(root.left) + rob(root.right);
        
        //choose root
        int withRoot = root.val;
        withRoot += (root.left == null) ? 
                        0 : rob(root.left.left) + rob(root.left.right);
        withRoot += (root.right == null) ? 
                        0 : rob(root.right.left) + rob(root.right.right);
        
        return Math.max(withRoot, noRoot);
    }
}
