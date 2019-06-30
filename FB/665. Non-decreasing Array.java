class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                //5879
                //modify nums[i-1] of a priority
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    //3424
                    //have to modify nums[i]
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return count <= 1;
    }
}
