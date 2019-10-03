class Solution {
    public boolean increasingTriplet(int[] nums) {
        //不断更新最小值min1和次小值min2 若当前值> min2 ruturn true;
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min2) {
                return true;
            }
            if (nums[i] <= min1) {
                //min2 = Integer.MAX_VALUE;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }
        }
        
        return false;
    }
}
