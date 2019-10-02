//dp 还可以继续优化空间
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix.
        int[][] dp = new int[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                        dp[i - 1][j - 1]) + 1;
                }
                count = Math.max(count, dp[i][j]);
            }
        }
        
        return count * count;
    }
}
