class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums[0];
        int n = nums.length;
        int[] maxPro = new int[n];
        int[] minPro = new int[n];
        
        maxPro[0] = minPro[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                maxPro[i] = 0;
            }else if (nums[i] > 0) {
                maxPro[i] = Math.max(maxPro[i - 1] * nums[i], nums[i]);
                minPro[i] = Math.min(minPro[i - 1] * nums[i], nums[i]);
            } else {
                maxPro[i] = Math.max(minPro[i - 1] * nums[i], nums[i]);
                minPro[i] = Math.min(maxPro[i - 1] * nums[i], nums[i]);
            }
            res = Math.max(res, maxPro[i]);
        }
        
        return res;
    }
}
