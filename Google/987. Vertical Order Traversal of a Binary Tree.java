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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);
        //print results
        for (TreeMap<Integer, PriorityQueue<Integer>> tm : map.values()) {
            List<Integer> curr = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : tm.values()) {
                while (!nodes.isEmpty()) {
                    curr.add(nodes.poll());
                }
            }
            res.add(curr);
        }
        
        return res;
    }
    
    private void dfs (TreeNode node, int x, int y,  TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(node.val);
        dfs(node.left, x - 1, y + 1, map);
        dfs(node.right, x + 1, y + 1, map);
        //since treemap默认从最小到最大 若是y - 1 则输出顺序就是从下层到上层
    } 
}
