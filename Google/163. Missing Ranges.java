class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        for (int n : nums) {
            // if num is MIN, num - 1 will be MAX
            if (n == Integer.MIN_VALUE) {
                lower = n + 1;
                continue;
            }
            
            int currBelow = n - 1;
            if (lower == currBelow) {
                res.add(lower + "");
            } else if (lower < currBelow) {
                res.add(lower + "->" + currBelow);
            }
            lower = n + 1;
            
            // if the last num is MAX, num + 1 will be MIN
            if (lower == Integer.MIN_VALUE) {
                return res;
            }
        }
        
        if (lower == upper) {
            res.add(lower + "");
        } else if (lower < upper) {
            res.add(lower + "->" + upper);
        } 
        
        return res;
    }
}

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(getRange(lower, upper));
            return res;
        }
        
        //假设nums全在范围内
        //check lower at first
        if (nums[0] != lower) {
            res.add(getRange(lower, nums[0] - 1));
        }
        
        int i = 1;
        while (i < nums.length) {
            //[-2147483648,-2147483648,0,2147483647,2147483647] overflow
            if (nums[i - 1] == Integer.MAX_VALUE) {
                return res;
            }
            
            //[1,1,1]with duplicate
            if (nums[i] > nums[i - 1] + 1) {
                int start = nums[i - 1] + 1;
                int end = nums[i] - 1;
                
                res.add(getRange(start, end));
            }
            i++;
        }
        
        //check upper at last
        if (nums[nums.length - 1] != upper) {
            res.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        
        return res;
    }
    
    private String getRange(int lower, int upper) {
        return lower == upper? lower + "" : lower + "->" + upper;
    }
}
