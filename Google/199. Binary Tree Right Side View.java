//DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        dfs(root, 0, res);
        
        return res;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (res.size() == level) {
            res.add(root.val);
        }
        
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }
}

//BFS
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //res.add(root.val);
        Map<Integer, Integer> map = new HashMap<>();
        //map.put(0, root.val);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //System.out.println(node.val);
                
                if (!map.containsKey(level)) {
                    map.put(level, node.val);
                    res.add(node.val);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            level++;
        }
        
        return res;
    }
}
