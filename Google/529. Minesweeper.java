//DFS
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        helper(board, click[0], click[1]);
        return board;
    }
    
    private void helper(char[][] board, int i, int j) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board[i][j] != 'E') {
            return;
        }
        
        //count number of mines aroung it
        int count = 0;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
               && board[row][col] == 'M') {
                count++;
            }
        }
        
        if (count == 0) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
                    helper(board, row, col);
                }
            }
        } else {
            board[i][j] = (char)(count +'0');
        }
    }
}

//BFS

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            //check num of mines first 
            //if num > 0 set it as count else offer it into queue
            int[] point = queue.poll();
            int count = 0;
            for (int[] dir : dirs) {
                int row = point[0] + dir[0];
                int col = point[1] + dir[1];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length 
                   && board[row][col] == 'M') {
                    count++;
                }
            }
            
            if (count > 0) {
                board[point[0]][point[1]] = (char)(count + '0');
            } else {
                board[point[0]][point[1]] = 'B';
                for (int[] dir : dirs) {
                    int row = point[0] + dir[0];
                    int col = point[1] + dir[1];
                    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length 
                       && board[row][col] == 'E') {
                        queue.offer(new int[] {row, col});
                        board[row][col] = 'B';// Avoid to be added again.
                    }
                }
            }
        }
        
        return board;
    }
}
