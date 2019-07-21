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
    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c) || c == '-') {
                //find node.value such as 14
                int j = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                int num = Integer.valueOf(s.substring(j, i + 1));
                TreeNode node = new TreeNode(num);
                if (!stack.empty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = node;
                    } else {
                        parent.left = node;
                    }
                }
                stack.push(node);
            }
        }
        
        return stack.peek();
    }
}
