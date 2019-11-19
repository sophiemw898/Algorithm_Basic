//dp O(N)
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            //initialization. i is max
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) 
                    && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}
