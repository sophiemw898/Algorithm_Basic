class NumArray {
    //preSum 
    int[] preSum;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return preSum[j] - preSum[i] + nums[j];
    }
    
    //update(i, val) Modify the element whose index is i to val.
    public void update(int i, int val) {
        int diff = val - nums[i];
        for (int j = i + 1; j <= nums.length; j++) {
            preSum[j] = preSum[j] + diff;
            //System.out.println(preSum[j]);
        } 
        nums[i] = val;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
