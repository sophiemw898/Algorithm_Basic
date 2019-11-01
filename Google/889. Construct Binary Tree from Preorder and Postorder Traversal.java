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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        
        //find the length of root.left 
        int L = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] ==  pre[1]) {
                L = i + 1; 
            }
        }
    
        //pre [0] [1, L] [L + 1, N]
        //post[0, L-1] [L, N - 1]
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, pre.length), Arrays.copyOfRange(post, L, pre.length - 1));
        
        return root;
    }
}
