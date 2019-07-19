//bfs
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //记录index和对应的node.val 
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> index = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        index.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int i = index.poll();
            //update map
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            } 
            map.get(i).add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                index.offer(i - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                index.offer(i + 1);
            }
        }
        
        //generate res from map
        //map.keySet __ no order
        // for (int n : map.keySet()) {
        //     res.add(map.get(n));
        // }
        for (int i = Collections.min(map.keySet()); i <= Collections.max(map.keySet()); i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}
