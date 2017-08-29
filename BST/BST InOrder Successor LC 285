//285 recursion
class Solution{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(root == null){
            return null;
        }
        if(p.val <= root.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left; 
        }    
    }
}


//Iteration
class Solution{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(root == null){
            return null;
        }
        TreeNode newroot = null;
        while(root != null){
            if(p.val < root.val){
                newroot = root;
                root = root.left;
            }else{
                root = root.right;
            } 
        }
        return newroot;
    }
}
