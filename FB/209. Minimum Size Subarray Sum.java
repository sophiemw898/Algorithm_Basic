//two points O(N)
简化之后
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        for (; start < nums.length; start++) {
            
            while (sum < s && end < nums.length) {
                sum += nums[end];
                end++;
            }
            
            if (sum >= s) {
                res = Math.min(res, end - start);
            }
    
            sum -= nums[start];
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            while (sum < s && end < nums.length) {
                sum += nums[end];
                end++;
            }
            
            if (sum >= s) {
                res = Math.min(res, end - start);
            }
            
          //update index start;
            while (sum >= s && start < end) {
                res = Math.min(res, end - start);
                
                sum -= nums[start];
                start++;
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
