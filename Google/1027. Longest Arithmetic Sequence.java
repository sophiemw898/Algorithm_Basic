//dp[diff][index] equals to the length of arithmetic sequence at index with difference diff
class Solution {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        
        int res = 2;
        
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                int len = dp[j].containsKey(d) ? dp[j].get(d) + 1 : 2;
                dp[i].put(d, len);
                res = Math.max(res, len);
            }
        } 
        
        return res;
    }
}
