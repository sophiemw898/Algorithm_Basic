class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return res;
    }
}

//all positive
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        int sum = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);
        
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             if (map.containsKey(sum - k)) {
//                 res = Math.max(res, i - map.get(sum - k));
//             }
//             if (!map.containsKey(sum)) {
//                 map.put(sum, i);
//             }
//         }
        
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > k) {
                //res = Math.min(res, i - start + 1);
                sum -= nums[start];
                start++;
            }
            if (sum == k) {
                res = Math.max(res, i - start + 1);
            }
        }
        
        return res;
    }
}
