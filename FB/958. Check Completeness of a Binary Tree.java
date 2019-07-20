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
    public boolean isCompleteTree(TreeNode root) {
        //Use BFS to do a level order traversal,
        //add childrens to the bfs queue,
        // until we met the first empty node.

        // For a complete binary tree,
        // there should not be any node after we met an empty one.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        // 1 2 3 4 5 # 7 # # # #
        
        //发现第一个空之后弹出后面所有的# 看看能不能把队列弹空
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        
        return queue.isEmpty();
    }
}
