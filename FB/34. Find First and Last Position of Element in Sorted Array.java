class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int[] res = new int[2];
        //find first target
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        } else {
            return new int[] {-1, -1};
        }
        
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            res[1] = end;
        } else if (nums[start] == target) {
            res[1] = start;
        } else {
            return new int[] {-1, -1};
        }
        
        return res;
    }
}
