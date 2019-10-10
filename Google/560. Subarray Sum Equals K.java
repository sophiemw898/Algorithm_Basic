//3rd user map to save the sum and times of this sum
//O(n) O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
}


//2nd user preSum to save the sum of elements before current one O(N^2) O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] =  sum[i - 1] + nums[i - 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }   
        }
        
        return count;
    }
}

//1st O(N^2) O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int curr;
        
        for (int i = 0; i < nums.length; i++) {
            curr = 0;
            for (int j = i; j < nums.length; j++) {
                curr += nums[j];
                if (curr == k) {
                    count++;
                }
            }   
        }
        
        return count;
    }
}
