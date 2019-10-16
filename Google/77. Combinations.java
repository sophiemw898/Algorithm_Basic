class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        helper(1, n, k, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int pos, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            helper(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
