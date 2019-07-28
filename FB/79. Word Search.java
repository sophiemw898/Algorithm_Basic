//dfs
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        //mark as visited
        board[i][j] = '*';
        if (helper(board, i + 1, j, word, index + 1) 
            || helper(board, i - 1, j, word, index + 1) 
            || helper(board, i, j + 1, word, index + 1)
            || helper(board, i, j - 1, word, index + 1)) {
            return true;
        }
        
        //change the mark back
        board[i][j] = word.charAt(index);
        return false;
    }
}
