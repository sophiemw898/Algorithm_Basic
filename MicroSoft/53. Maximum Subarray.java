class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        //dp[i] means the maximum subarray ending with A[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}

//**********
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}
