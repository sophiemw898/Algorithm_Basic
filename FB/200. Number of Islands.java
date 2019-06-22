class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }   
        return count;
    }
    
    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int m = grid.length;
        int n = grid[0].length; 
        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.offer(n * x + y);
        while (!neighbors.isEmpty()) {
            int curr = neighbors.remove();
            int row = curr / n;
            int col = curr % n;
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                neighbors.offer((row - 1) * n + col);
                grid[row - 1][col] = '0';
            }
            if (row + 1 < m && grid[row + 1][col] == '1') {
                neighbors.offer((row + 1) * n + col);
                grid[row + 1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                neighbors.offer(row * n + col - 1);
                grid[row][col - 1] = '0';
            }
            if (col + 1 < n && grid[row][col + 1] == '1') {
                neighbors.offer(row * n + col + 1);
                grid[row][col + 1] = '0';
            }
        }
    }
}
