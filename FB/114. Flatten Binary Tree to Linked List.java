//Divide and Conquer
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }   
}

//DFS
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightTail != null) {
            return rightTail;
        }
        
        if (leftTail != null) {
            return leftTail;
        }
        
        return root;
    }
}
