//there are two stages for each day, holding stock in hand and just cash in hand
//cash[i] the cash in hand, if you are not holding the stock at the end of day(i)
//hold[i] the cash in hand, if you are holding the stock at the end of day(i)

//return cash[n - 1];
//cash[i] = Math.max(cash[i - 1], hold[i] + prices[i] - fee)
//hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i])
class Solution {
    public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[] cash = new int[n];
//         int[] hold = new int[n];
//         cash[0] = 0;
//         hold[0] = -prices[0];
        
//         for (int i = 1; i < n; i++) {
//             cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i] - fee);
//             hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
//         }
        
//         return cash[n - 1];
        
        int cash = 0;
        int hold = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        
        return cash;
    }
}
