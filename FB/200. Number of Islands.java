//dfs
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
                    dfs(grid, i, j);
                    count++;
                }
            }
        }   
        return count;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length; 
        
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
            return;
        }
        
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}

//bfs
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
        int[] dir = new int[] {0, -1, 0, 1, 0};
        int m = grid.length;
        int n = grid[0].length; 
        Queue<Integer> neighborsX = new LinkedList<>();
        Queue<Integer> neighborsY = new LinkedList<>();
        neighborsX.offer(x);
        neighborsY.offer(y);
        while (!neighborsX.isEmpty()) {
            int row = neighborsX.poll();
            int col = neighborsY.poll();
            
            for (int i = 0; i < 4; i++) {
                int newX = row + dir[i];
                int newY = col + dir[i + 1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == '1') {
                    neighborsX.offer(newX);
                    neighborsY.offer(newY);
                    grid[newX][newY] = '0';
                }
            }
        }
    }
}

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
