//O(N) O(H)
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            return true;
        }
        
        boolean left = isUnivalTree(root.left);
        boolean right = isUnivalTree(root.right);
        
        if (root.left == null) {
            return left && right && root.val == root.right.val;
        }
        
        if (root.right == null) {
            return left && right && root.val == root.left.val;
        }
        
        return left && right && root.val == root.left.val && root.val == root.right.val;
    }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
