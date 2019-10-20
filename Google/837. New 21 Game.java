/*
Explanation:
In a word,
dp[i]: probability of get points i
dp[i] = sum(last W dp values) / W

To get Wsum = sum(last W dp values), we can maintain a sliding window with size at most W.

Time Complexity:
O(N)

*/

class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
            return 1;
        }
        
        double[] dp = new double[N + 1];
        dp[0] = 1; 
        double sum = 1;
        double res = 0;
        
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            //维护W时间框
            if (i >= W) {
                sum -= dp[i - W];
            } 
            //小于K继续扔，维护当前可能性的和
            if (i < K) {
                sum += dp[i];
            } else {
                //大于K后不再扔，概率加入结果
                res += dp[i];
            }
        }
        
        return res;
    }
}
