//find it or the first index > target
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //need to check == if they did not go into while loop
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        if (nums[start] > target) {
            return start;
        }
        if (nums[end] > target) {
            return end;
        }

        return nums.length;
    }
}
