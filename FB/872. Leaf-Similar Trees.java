class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String leaves1 = getLeaves(root1);
        String leaves2 = getLeaves(root2);
        return leaves1.equals(leaves2);
    }
    
    private String getLeaves(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return "" + root.val;
        }
        return getLeaves(root.left) + getLeaves(root.right);
    }
}
