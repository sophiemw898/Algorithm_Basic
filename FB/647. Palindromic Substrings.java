//dp O(n2)
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int n = s.length();
        //use dp[i][j] to record if substring(i, j+1) is palindadrome
        boolean[][] dp = new boolean[n][n];
        
        //initializaiton
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        //dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)
        for (int depth = 2; depth < n; depth++) {
            for (int i = 0; i < n - depth; i++) {
                int j = i + depth;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}
