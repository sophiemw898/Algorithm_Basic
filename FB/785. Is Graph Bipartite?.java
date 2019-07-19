/**
Complexity Analysis

Time Complexity: O(N + E)
O(N+E), where N is the number of nodes in the graph, and E is the number of edges. We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.

Space Complexity: O(N)
O(N), the space used to store the color.
*/
//BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;
                
                while (!stack.empty()) {
                    int node = stack.pop();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            stack.push(neighbor);
                            color[neighbor] = (color[node] == 0) ? 1 : 0;
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
