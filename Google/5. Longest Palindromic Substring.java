class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int dist = 1;
        String res = s.substring(0, 1);
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     dp[i][i] = true;
        // }
        
        // for (int d = 1; d < n; d++) {
        //     for (int i = 0; i < n; i++) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) 
                    && (j - i < 2 || dp[i + 1][j - 1]);
                
                if (dp[i][j] && dist < j - i + 1) {
                    dist = j - i + 1;
                    res = s.substring(i, j + 1);
                } 
            }
        }
        
        return res;
    }
}
