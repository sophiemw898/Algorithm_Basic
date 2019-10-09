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
        //use map to save the path and then print shortest path
        Map<int[], int[]> map = new HashMap<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] curr = queue.poll();
                
                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    System.out.println(curr[0] + "," + curr[1]);
                    while (map.containsKey(curr)) {
                        System.out.println(map.get(curr)[0] + "," + map.get(curr)[1]);
                        curr = map.get(curr);
                    }
                    
                    return res;
                }
                
                for (int i = 0; i < 8; i++) {
                    int row = curr[0] + dirX[i];
                    int col = curr[1] + dirY[i];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0) {
                        int[] next = new int[] {row, col};
                        queue.offer(next);
                        grid[row][col] = 1;
                        map.put(next, curr);
                    }
                }
            }
            
            res++;
        }
        
        return -1;
    }
}
