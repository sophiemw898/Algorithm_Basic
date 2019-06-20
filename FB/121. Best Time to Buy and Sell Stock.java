//其实用不上dp 见⬇️
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int max_pro = 0;
        //dp[i] records the min value before i      
        int[] dp = new int[prices.length];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i - 1]);
            //System.out.println(dp[i]);
            max_pro = Math.max(max_pro, prices[i] - dp[i]);
            //System.out.println(max_pro);
        }
        
        return max_pro;   
    }
}

//O(N) O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int max_profit = 0;
        int min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min_price = Math.min(min_price, prices[i - 1]);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }
        
        return max_profit;   
    }
}
