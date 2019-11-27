//DFS
class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(char[][] board) {
        int[] dir = new int[] {1, 0, -1, 0, 1};
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        
        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void dfs(char[][]board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return; 
        }
        board[i][j] = '+';
        int[] dir = new int[] {0, 1, 0, -1, 0};
        for (int index = 0; index < 4; index++) {
            int row = i + dir[index];
            int col = j + dir[index + 1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length 
                && board[row][col] == 'O') {
                dfs(board, row, col);
            }
        }
    }
}
//BFS
class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(char[][] board) {
        int[] dir = new int[] {1, 0, -1, 0, 1};
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        Queue<Pos> queue = new LinkedList<>();

        //Initialization
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Pos(i, 0));
                board[i][0] = '+';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new Pos(i, n - 1));
                board[i][n - 1] = '+';
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Pos(0, i));
                board[0][i] = '+';
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new Pos(m - 1, i));
                board[m - 1][i] = '+';
            }
        }
        
        while (!queue.isEmpty()) {
            Pos node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = node.x + dir[i];
                int col = node.y + dir[i + 1];
                if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'O') {
                    queue.offer(new Pos(row, col));
                    board[row][col] = '+';
                    //System.out.println(row + "''" + col);
                }
            }
        }
        
        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
}
