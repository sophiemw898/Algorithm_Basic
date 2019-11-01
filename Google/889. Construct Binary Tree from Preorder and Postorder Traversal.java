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

class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        
        return dfs(pre, 0, pre.length - 1 , post, 0, post.length - 1, map);    
        //pre [0] [1, L] [L + 1, N]
        //post[0, L-1] [L, N - 1]
    }
    
    private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart + 1 <= preEnd) {
            int L = map.get(pre[preStart + 1]) - postStart;
            root.left = dfs(pre, preStart + 1, preStart + 1 + L, post, postStart, postStart + L, map);
            root.right = dfs(pre, preStart + 1 + L + 1, preEnd, post, postStart + L + 1, postEnd - 1, map);
        }
        
        return root;
    }
}
