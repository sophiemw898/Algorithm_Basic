//O(N)
class Solution {
    public int maximumProduct(int[] nums) {
        //find the required 2 smallest values(min1,min2) and 
        //the three largest values(max1,max2,max3) in the nums array
        //by iterating over the nums array only once.
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

//O(NlogN)
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max((nums[0] * nums[1] * nums[nums.length - 1]), 
                        (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]));
    }
}
