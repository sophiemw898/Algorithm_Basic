//solve超时 不需要每次都计算乘集，可以把计算好的乘级记录下来
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }        
        return result;
    }
}

//超时 不需要每次都计算乘集，可以把计算好的乘级记录下来
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = product(nums, 1, nums.length - 1);
            } else if (i == nums.length - 1) {
                result[i] = product(nums, 0, nums.length - 2);
            } else {
                result[i] = product(nums, 0, i - 1) * product(nums, i + 1, nums.length -1);
            }
        }
        
        return result;
    }
    
    private int product(int[] nums, int x, int y) {
        int res = 1;
        for (int i = x; i <= y; i++) {
            res *= nums[i];
        }
        
        return res;
    }
}
