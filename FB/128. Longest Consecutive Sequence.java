//set O(N) O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int res = 0;
        
        for (int num : nums) {
            //no num - 1 in set, then num is the first num
            if (!set.contains(num - 1)) {
                int count = 1;
                int temp = num;
                
                while (set.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                
                //update res
                res = Math.max(res, count);
            } 
        }
        
        return res;
    }
}

//sort O(NlogN) O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 1;
        Arrays.sort(nums);//O(NlogN)
        
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == temp + 1) {
                    count++;
                    temp = nums[i];
                } else {
                    res = Math.max(res, count);
                    count = 1;
                    temp = nums[i];
                }
            }

        }
        
        return Math.max(res,count);
        //[1,2,0,1] have same number, skip it, output 3
    }
}
