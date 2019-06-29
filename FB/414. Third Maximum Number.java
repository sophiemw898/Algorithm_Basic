class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        //或者用null不过要注意付值前三项
        //use int test wrong[1,2,-2147483648]
        // int max1 = Integer.MIN_VALUE; 
        // int max2 = Integer.MIN_VALUE;
        // int max3 = Integer.MIN_VALUE;
        
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max1 || nums[i] == max2 || nums[i] == max3) {
                continue;
            }
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        
        return (int)(max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
