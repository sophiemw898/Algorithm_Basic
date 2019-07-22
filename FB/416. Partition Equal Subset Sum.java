// find whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2)
class Solution {
    public boolean canPartition(int[] nums) {
        //记录preSum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        
        //dp[i] means 能不能形成和为sum的组合
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) { 
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        
        return dp[sum];
    }
}


// find whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2)
class Solution {
    public boolean canPartition(int[] nums) {
        //记录preSum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        
        int n = nums.length;
        //dp[i][j] means 前i个数字能不能形成和为sum的组合
        //dp[i][j] = dp[i - 1][j - nums[i]] （用nums[i]）
        //dp[i][j] = dp[i - 1][j]（不用nums[i]）
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i -  1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
    }
}
