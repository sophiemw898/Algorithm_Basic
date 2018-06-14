class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
}
