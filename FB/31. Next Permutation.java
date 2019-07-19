//O(N) O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        //从最后一个位置开始，找到一个上升点，上升点之前的无需改动
        //1 5 8 4 7 6 5 3 1  get 4
        int firstChange = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                firstChange = i - 1;
                break;
            }
        }
        
        //然后，翻转上升点之后的降序。
        reverse(nums, firstChange + 1, nums.length - 1);
        
        //7,6,5,4 直接返回4，5，6，7
        if (firstChange == -1) {
            return;
        }
        
        //在降序里，找到第一个比上升点大的，交换位置。
        int changed = nums.length - 1;
        for (int i = firstChange + 1; i < nums.length; i++) {
            if (nums[i] > nums[firstChange]) {
                changed = i;
                break;
            }
        }
        
        int temp = nums[changed];
        nums[changed] = nums[firstChange];
        nums[firstChange] = temp;
        
        return;
    }
    
    private void reverse(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        return;
    }
}
