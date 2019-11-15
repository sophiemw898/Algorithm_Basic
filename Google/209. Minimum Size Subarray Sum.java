class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
