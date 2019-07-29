class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
