class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //sort O(NlogN)
        //Set O(N) with extra space
        
        //O(N) no extras space 
        //make the index with neg
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}
