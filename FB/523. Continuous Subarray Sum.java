//hashmap O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        
        return false;
    }
}

//O(n^2)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1]; 
            for (int j = 0; j < i; j++) {
                if ((presum[i] - presum[j] + nums[i]) == k) {
                    return true;
                }
                if (k != 0 && (presum[i] - presum[j] + nums[i]) % k == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
