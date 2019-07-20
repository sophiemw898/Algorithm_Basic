class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int[] dir = new int[] {-1, 0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();       
        
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] room = queue.poll();
                int row = room[0];
                int col = room[1];
                for (int index = 0; index < 4; index++) {
                    int r = row + dir[index];
                    int c = col + dir[index + 1];
                    if (r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length 
                        && rooms[r][c] == Integer.MAX_VALUE) {
                        rooms[r][c] = rooms[row][col] + 1;
                        queue.offer(new int[] {r, c});
                    }
                }
            }
        }
    }
}
