class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        
        int[] dirX = new int[] {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirY = new int[] {1, 0, -1, 0, 1, -1, -1, 1};
        
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] curr = queue.poll();
                
                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    return res;
                }
                
                for (int i = 0; i < 8; i++) {
                    int row = curr[0] + dirX[i];
                    int col = curr[1] + dirY[i];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0) {
                        queue.offer(new int[] {row, col});
                        grid[row][col] = 1;
                    }
                }
            }
            
            res++;
        }
        
        return -1;
    }
}
