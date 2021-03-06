class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        boolean[] isVisited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, isVisited);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] isVisited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            temp.add(nums[i]);
            isVisited[i] = true;
            helper(nums, temp, res, isVisited);
            temp.remove(temp.size() - 1);
            isVisited[i] = false;
        }
    }
}
