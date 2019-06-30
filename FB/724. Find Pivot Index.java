//答案
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0, leftsum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum -nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}
//自己改1 
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] preSum = new int[nums.length + 1];
        
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == preSum[nums.length] - preSum[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
//1st
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        
        if (preSum[nums.length - 1] - preSum[0] == 0) {
            return 0;
        }
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (preSum[i - 1] == preSum[nums.length - 1] - preSum[i]) {
                return i;
            }
        }

        if (preSum[nums.length - 2] == 0) {
            return nums.length - 1;
        }
        return -1;
    }
}
