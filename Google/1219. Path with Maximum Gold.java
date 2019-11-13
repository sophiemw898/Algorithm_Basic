class Solution {
    
    int res = 0;
    public int getMaximumGold(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    //System.out.println(grid[i][j]);
                    dfs(grid, i, j, 0);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, int sum) {
        int[] dir = new int[] {0,1,0,-1,0};
        //System.out.println(grid[i][j]);
        sum += grid[i][j];
        
        if (sum > res) {
            res = sum;
        }
        
        int old = grid[i][j];
        grid[i][j] = 0;
        
        for (int index = 0; index < 4; index++) {
            int row = i + dir[index];
            int col = j + dir[index + 1];
            
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0) {
                dfs(grid, row, col, sum);
            }
        }
        
        //backtrack
        grid[i][j] = old;
        //res = Math.max(res, sum);
        return;
    }
}
