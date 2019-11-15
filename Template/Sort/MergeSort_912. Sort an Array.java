class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        
        mergeSort(nums, start, (start + end) / 2, temp);
        mergeSort(nums, (start + end) / 2 + 1, end, temp);
        
        merge(nums, start, end, temp);
    }
    
    private void merge(int[] nums, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        
        int index = start;
        
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        
        while (right <= end) {
            temp[index++] = nums[right++];
        }
        
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
