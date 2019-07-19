class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antiDiagonal = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int curr = (player == 1) ? 1 : -1;
        int size = rows.length;
        rows[row] += curr;
        cols[col] += curr;
        //System.out.println(cols[col]);
        if (row == col) {
            diagonal += curr;
        }
        if (row + col == size - 1) {
            antiDiagonal += curr;
        }
        
        if (Math.abs(rows[row]) == size 
            || Math.abs(cols[col]) == size
            || Math.abs(diagonal) == size
            || Math.abs(antiDiagonal) == size) {
            
            return player;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
