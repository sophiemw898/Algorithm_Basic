class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        quickSort(nums, 0, nums.length - 1);
        
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        //1. pivot
        int pivot = nums[(start + end) / 2];
        
        //2. left <= right not left < right
        //【1， 2】 stackoverflow
        while (left <= right) {
            
            //3. nums[left] < pivot 不能nums[left] <= pivot 
            //不然 1，1，1，1，1全相等的时候都去了左面 没有尽可能的均分
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }
        }
        
        //退出的时候right <= left 必须错开 不然会stackoverflow 所以不能用right < left
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
