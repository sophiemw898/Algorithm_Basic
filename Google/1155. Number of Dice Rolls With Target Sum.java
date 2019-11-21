//O(d*f*target)
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        int MOD = 1000000007;
        
        for (int i = 1; i <= target; i++) {
            dp[1][i] = (i <= f) ? 1 : 0;
        }
        
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j > k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                    }
                }
            }
        }
        
        return dp[d][target];
    }
}
