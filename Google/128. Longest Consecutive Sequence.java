//O(nlogn) O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int res = 1;
        Arrays.sort(nums);
        
        int count = 1;
        int cur = nums[0];
        
        //have same number in array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == cur + 1) {
                    count++;
                    cur++;
                } else {
                    res = Math.max(res, count);
                    count = 1;
                    cur = nums[i];
                }
            }
        }
        
        return Math.max(res, count);        
    }
}

//O(N) O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        
        Set<Integer> set = new HashSet<>();
        int res = 1;
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curLength = 1;
                int curNum = nums[i];
                
                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
                
                res = Math.max(res, curLength);
            }
        }
        
        return res;        
    }
}
