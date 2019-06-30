
class Solution {
     public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }
    //return head
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
//recursion
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        for (int val : vals) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        
        return ans.right;
    }
    
        private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
