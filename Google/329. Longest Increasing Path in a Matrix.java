Time complexity : O(mn). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once. 
The total time complexity is then O(V+E). 
    V is the total number of vertices and E is the total number of edges. 
    In our problem, O(V) = O(mn), O(E) = O(4V) = O(mn)

Space complexity : O(mn) The cache dominates the space complexity.
    
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        int[] dir = new int[] {0, 1, 0, -1, 0};
        cache[i][j] = 1;
        for (int index = 0; index < 4; index++) {
            int row = i + dir[index];
            int col = j + dir[index + 1];
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length 
                && matrix[row][col] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, row, col, cache) + 1);
            }
        }
        
        return cache[i][j];
    }
}
