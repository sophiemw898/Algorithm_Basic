//guarante to win between i , j 可以选择最优策略
//if we choose x, we need to ensure to cover(i, x-1) and cover(x+ 1, j)
//so we need the range maxLocalX = x + Math.max(dp[i][x-1], dp[x+1][j])
// dp[i][j] = Math.min(all minLocalX)

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        
        for(int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                //Initialization
                dp[i][j] = Integer.MAX_VALUE;
                if (i + 1 == j) {
                    dp[i][j] = i;
                } else {
                    //转移方程
                    for (int d = i + 1; d < j; d++) {
                        int maxLocalX = d + Math.max(dp[i][d - 1], dp[d + 1][j]);
                        dp[i][j] = Math.min(dp[i][j], maxLocalX);
                    }
                }
            }
        }
        
        return dp[1][n];
    }
}
