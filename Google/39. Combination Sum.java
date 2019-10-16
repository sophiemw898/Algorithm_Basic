class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        Arrays.sort(candidates);
        helper(res, candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> temp, int currSum, int pos) {
        // if (currSum > target) {
        //     return;
        // }
        if (currSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            temp.add(candidates[i]);
            if (candidates[i] <= target - currSum) {
                helper(res, candidates, target, temp, currSum + candidates[i], i);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
