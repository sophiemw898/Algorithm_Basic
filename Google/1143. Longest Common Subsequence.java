//O(NM)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //corner case
        //both null or empty, retunr 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = text2.charAt(i) == text1.charAt(0) ? 1 : dp[0][i - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
