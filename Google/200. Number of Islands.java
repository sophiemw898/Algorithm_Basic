class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        int[] dir = new int[] {-1, 0, 1, 0, -1};
        
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.offer(i);
        queueY.offer(j);
        grid[i][j] = '0';
        
        while(!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            for (int index = 0; index < 4; index++) {
                int row = x + dir[index];
                int col = y + dir[index + 1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
                    queueX.offer(row);
                    queueY.offer(col);
                    grid[row][col] = '0';
                }
            }
        }
    }
}
